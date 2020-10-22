/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-06-12 15:31:07
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: \tacomall-springboot\tacomall-api\tacomall-api-open\src\main\java\cn\codingtalk\tacomallapiopen\service\impl\OssServiceImpl.java
 * @Just do what I think it is right
 */
package store.tacomall.apiopen.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import org.springframework.stereotype.Service;

import store.tacomall.apiopen.config.OssConfig;
import store.tacomall.apiopen.service.OssService;
import store.tacomall.common.vo.ResponseVo;

@Service
public class OssServiceImpl implements OssService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ResponseVo<Map<String, Object>> authorize(String dir) {
        ResponseVo<Map<String, Object>> responseVo = new ResponseVo();
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
            map.put("accessKey", OssConfig.accessKey);
            map.put("dir", dir);
            map.put("expire", OssConfig.expire);
            map.put("host", OssConfig.host);
            map.put("policy", encodedPolicy);
            map.put("signature", postSignature);
        } catch (Exception e) {
            this.logger.info("storage authorize fail");
        }
        responseVo.setData(map);
        return responseVo;
    }
}
