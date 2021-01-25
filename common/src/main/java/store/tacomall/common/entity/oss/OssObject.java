/***
 * @Author: 码上talk|RC
 * @Date: 2020-12-29 14:38:48
 * @LastEditTime: 2020-12-29 14:42:11
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/common/src/main/java/store/tacomall/common/entity/oss/OssObject.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.common.entity.oss;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class OssObject {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String filename;

    private String endpoint;

    private String bucket;

    private String url;

    private int isDelete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

}
