package wiki.laona.boot.pojo.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author laona
 * @description 用户类
 * @create 2021-07-12 20:53
 **/
@Data
@TableName("customer")
public class Customer {

    /**
     * 用户主键，策略：雪花主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
