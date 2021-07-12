package wiki.laona.boot.pojo.vo;

import lombok.Data;
import wiki.laona.boot.handler.BizException;
import wiki.laona.boot.pojo.dao.Customer;

/**
 * @author laona
 * @description 响应结果
 * @create 2021-07-12 21:22
 **/
@Data
public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    /**
     * 登录成功
     *
     * @return {@linkplain Result} 响应结果
     */
    public static Result<Customer> loginSuccess(Customer customer) {
        customer.setPassword(null);
        return new Result<>(ResultCode.LOGIN_SUCCESS, customer);
    }

    /**
     * 登录失败
     *
     * @return {@linkplain Result} 响应结果
     */
    public static Result<?> loginFailed() {
        return new Result<>(ResultCode.LOGIN_FAILED, null);
    }

    /**
     * 验证码错误
     *
     * @return {@linkplain ResultCode} 响应结果
     */
    public static Result<?> verifyError() {
        return new Result<>(ResultCode.VERIFY_ERROR, null);
    }

    /**
     * 退出登录成功
     *
     * @return {@linkplain ResultCode} 响应结果
     */
    public static Result<?> logoutSuccess() {
        return new Result<>(ResultCode.LOGIN_OUT_SUCCESS, null);
    }

    /**
     * 自定义异常
     *
     * @param e {@linkplain ResultCode} 响应状态码
     * @return 异常结果
     */
    public static Result<?> definedError(BizException e) {
        return new Result<>(ResultCode.DEFINED_EXCEPTION, e);
    }

    /**
     * 其他异常
     *
     * @param e {@linkplain ResultCode} 响应状态码
     * @return 异常结果
     */
    public static Result<?> othersError(Exception e) {
        return new Result<>(ResultCode.OTHERS_EXCEPTION, e);
    }
}
