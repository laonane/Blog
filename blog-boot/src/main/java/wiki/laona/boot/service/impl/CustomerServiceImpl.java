package wiki.laona.boot.service.impl;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wiki.laona.boot.handler.BizException;
import wiki.laona.boot.pojo.dao.Customer;
import wiki.laona.boot.pojo.vo.LoginVo;
import wiki.laona.boot.pojo.vo.Result;
import wiki.laona.boot.pojo.vo.ResultCode;
import wiki.laona.boot.service.ICustomerService;

/**
 * @author laona
 * @description 用户登录服务实现
 * @create 2021-07-12 22:02
 **/
@Service
@Transactional(rollbackFor = BizException.class)
public class CustomerServiceImpl implements ICustomerService<Customer> {

    @Override
    public Result<Customer> login(LoginVo loginVo) {
        if (ObjectUtils.anyNull(loginVo, loginVo.getUsername(), loginVo.getVerifyCode(), loginVo.getPassword())) {
            throw new BizException(ResultCode.OTHERS_EXCEPTION, new IllegalArgumentException("参数异常"));
        }
        // todo 校验
        return null;
    }

    @Override
    public Result<Customer> logout(LoginVo loginVo) {
        return null;
    }
}
