package wiki.laona.boot.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import wiki.laona.boot.pojo.vo.Result;

/**
 * @author laona
 * @description 全局异常处理
 * @create 2021-07-12 22:15
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 自定义异常
     *
     * @param e {@linkplain BizException} 异常信息
     * @return 异常结果
     */
    @ExceptionHandler
    @ResponseBody
    public Result<?> bizExceptionHandler(BizException e) {
        return Result.definedError(e);
    }

    /**
     * 其他异常
     *
     * @param e {@linkplain BizException} 异常信息
     * @return 异常结果
     */
    @ExceptionHandler
    @ResponseBody
    public Result<?> exceptionHandler(Exception e) {
        return Result.othersError(e);
    }
}
