/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-02 17:24:21
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-admin/src/main/java/cn/codingtalk/tacomallapimerchant/shiro/CORSAuthenticationFilter.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapimerchant.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import cn.codingtalk.tacomallcommon.vo.ResponseVo;
import cn.codingtalk.tacomallcommon.enumeration.BizEnum;

public class CORSAuthenticationFilter extends FormAuthenticationFilter {
    public CORSAuthenticationFilter() {
        super();
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (request instanceof HttpServletRequest) {
            if (((HttpServletRequest) request).getMethod().toUpperCase().equals("OPTIONS")) {
                System.out.println("OPTIONS请求");
                return true;
            }
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse res = (HttpServletResponse) response;
        ResponseVo<String> responseVo = new ResponseVo<>();
        responseVo.setCode(BizEnum.USER_NOT_LOGGED_IN.getCode());
        responseVo.setStatus(false);
        responseVo.setMessage(BizEnum.USER_NOT_LOGGED_IN.getMessage());
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setStatus(HttpServletResponse.SC_OK);
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=utf-8");
        PrintWriter writer = res.getWriter();
        writer.write(JSON.toJSONString(responseVo));
        writer.close();
        return false;
    }
}
