package cn.codingtalk.tacomallapiopen.config;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import cn.codingtalk.tacomallapiopen.properties.OssProperties;

@Configuration
@EnableConfigurationProperties(OssProperties.class)
public class OssConfig {
    private volatile static OSSClient client;

    public static String endpoint;

    public static String accessKey;

    public static String accessSecret;

    public static Long expire;

    public static String host;

    @Autowired
    public OssConfig(OssProperties properties) {
        endpoint = properties.getEndPoint();
        accessKey = properties.getAccesskey();
        accessSecret = properties.getAccessSecret();
        expire = properties.getExpire();
        host = properties.getHost();
    }


    public static OSSClient getOSSClient() {
        if (client == null) {
            synchronized (OssConfig.class) {
                if (client == null) {
                    client = new OSSClient(endpoint, accessKey, accessSecret);
                }
            }
        }
        return client;
    }
}
