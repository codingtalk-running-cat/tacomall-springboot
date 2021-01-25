/***
 * @Author: 码上talk|RC
 * @Date: 2020-10-19 18:49:35
 * @LastEditTime: ,: 2020-10-20 16:29:05
 * @LastEditors: ,: 码上talk|RC
 * @Description: 
 * @FilePath: ,: /tacomall-springboot/tacomall-api/tacomall-api-merchant/src/main/java/store/tacomall/apimerchant/handler/MyMetaObjectHandler.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.apimerchant.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "isDelete", int.class, 0);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}