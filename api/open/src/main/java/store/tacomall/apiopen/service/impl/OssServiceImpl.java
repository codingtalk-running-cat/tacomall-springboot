/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-12-29 16:29:26
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/api/open/src/main/java/store/tacomall/apiopen/service/impl/OssServiceImpl.java
 * @Just do what I think it is right
 */
package store.tacomall.apiopen.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.tacomall.apiopen.config.OssConfig;
import store.tacomall.apiopen.service.OssService;
import store.tacomall.common.vo.ResponseVo;
import store.tacomall.common.entity.oss.OssObject;
import store.tacomall.common.mapper.oss.OssMapper;

@Service
public class OssServiceImpl implements OssService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OssMapper ossMapper;

    @Override
    public ResponseVo<Map<String, Object>> authorize(String dir, int insertDb) {
        ResponseVo<Map<String, Object>> responseVo = new ResponseVo<>();
        Map<String, Object> map = new HashMap<>();
        try {
            OSSClient client = OssConfig.getOSSClient();

            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

            long expireEndTime = System.currentTimeMillis() + OssConfig.expire * 1000;
            Date expiration = new Date(expireEndTime);
            String postPolicy = client.generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes("utf-8");
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = client.calculatePostSignature(postPolicy);
            JSONObject jasonCallback = new JSONObject();
            jasonCallback.put("callbackUrl", OssConfig.callback);
            jasonCallback.put("callbackBody", "bucket=" + OssConfig.bucket + "&insertDb=" + insertDb
                    + "&filename=${object}&size=${size}&mimeType=${mimeType}&height=${imageInfo.height}&width=${imageInfo.width}");
            jasonCallback.put("callbackBodyType", "application/x-www-form-urlencoded");
            String base64CallbackBody = BinaryUtil.toBase64String(jasonCallback.toString().getBytes());
            map.put("accessKey", OssConfig.accessKey);
            map.put("dir", dir);
            map.put("expire", OssConfig.expire);
            map.put("host", OssConfig.host);
            map.put("policy", encodedPolicy);
            map.put("signature", postSignature);
            map.put("callback", base64CallbackBody);
        } catch (Exception e) {
            this.logger.info("Storage authorize fail");
        }
        responseVo.setData(map);
        return responseVo;
    }

    @Override
    public ResponseVo<OssObject> callback(HttpServletRequest request) {
        ResponseVo<OssObject> responseVo = new ResponseVo<>();
        OssObject ossObject = new OssObject();
        ossObject.setFilename(request.getParameter("filename"));
        ossObject.setBucket(request.getParameter("bucket"));
        if (Integer.valueOf(request.getParameter("insertDb")).equals(1)) {
            ossMapper.insert(ossObject);
        }
        responseVo.setData(ossObject);
        return responseVo;
    }
}
