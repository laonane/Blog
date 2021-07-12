package wiki.laona.boot.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author laona
 * @description 登录 vo
 * @create 2021-07-12 21:19
 **/
@Data
public class LoginVo implements Serializable {

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 验证码
     */
    private String verifyCode;
}
