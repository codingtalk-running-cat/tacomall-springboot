/***
 * @Author: 码上talk|RC
 * @Date: 2020-12-29 14:47:53
 * @LastEditTime: 2020-12-29 14:48:31
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/common/src/main/java/store/tacomall/common/mapper/oss/OssMapper.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.common.mapper.oss;

import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import store.tacomall.common.entity.oss.OssObject;

@Repository
public interface OssMapper extends BaseMapper<OssObject> {

}
