package wiki.laona.boot.pojo.vo;

/**
 * @author laona
 * @description 响应状态码
 * @create 2021-07-12 21:23
 **/
public enum ResultCode {

    /**
     * 登录成功
     */
    LOGIN_SUCCESS(1000, "登录成功"),
    /**
     * 登录失败
     */
    LOGIN_FAILED(1002, "登录失败"),
    /**
     * 验证码错误
     */
    VERIFY_ERROR(1003, "验证码错误"),
    /**
     * 验证码错误
     */
    LOGIN_OUT_SUCCESS(1004, "退出成功"),
    /**
     * 自定义异常
     */
    DEFINED_EXCEPTION(1500, "自定义异常"),
    /**
     * 其他异常
     */
    OTHERS_EXCEPTION(1501, "其他异常"),

    ;
    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String message;


    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
