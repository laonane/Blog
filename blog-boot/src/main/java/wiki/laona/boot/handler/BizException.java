package wiki.laona.boot.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import wiki.laona.boot.pojo.vo.ResultCode;

/**
 * @author laona
 * @description 业务异常
 * @create 2021-07-12 22:06
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BizException extends RuntimeException{
    private Integer code;
    private String message;

    public BizException(Integer code, String message, Throwable cause) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public BizException(ResultCode resultCode, Throwable cause) {
        super(cause);
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

}
