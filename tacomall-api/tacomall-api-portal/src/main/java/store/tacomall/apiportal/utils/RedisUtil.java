/***
 * @Author: 码上talk|RC
 * @Date: 2020-11-04 15:47:56
 * @LastEditTime: 2020-11-04 18:05:58
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/utils/RedisUtil.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apiportal.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Service;

@Service
public class RedisUtil {

    @Autowired
    RedisTemplate redisTemplate;

    public Long runScript(String luaFile, List<String> argv) {
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        redisScript.setResultType(Long.class);
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource(luaFile)));
        return (Long) redisTemplate.execute(redisScript, argv);
    }

    public void set(String key, String val) {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set(key, val);
    }

    public String get(String key) {
        ValueOperations ops = redisTemplate.opsForValue();
        return (String) ops.get(key);
    }

    public Boolean delete(String key) {
        return (Boolean) redisTemplate.delete(key);
    }

    public HashMap<String, String> select(String key) {

        Set<String> set = redisTemplate.keys(key);
        List<String> list = new ArrayList<>(set);

        HashMap<String, String> result = new HashMap<>();
        if (list.size() != 0) {
            for (String str : list) {
                result.put(str, (String) redisTemplate.opsForValue().get(str));
            }
        }
        return result;
    }
}