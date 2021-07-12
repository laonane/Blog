package wiki.laona.boot.service;

import wiki.laona.boot.pojo.dao.Customer;
import wiki.laona.boot.pojo.vo.LoginVo;
import wiki.laona.boot.pojo.vo.ResultCode;
import wiki.laona.boot.pojo.vo.Result;

/**
 * @author laona
 * @description 用户登录服务接口
 * @create 2021-07-12 21:15
 **/
public interface ICustomerService<T> {

    /**
     * 登录
     *
     * @param loginVo {@linkplain LoginVo} 登录 vo
     * @return 登录结果
     */
    Result<T> login(LoginVo loginVo);

    /**
     * 退出登录
     *
     * @param loginVo {@linkplain LoginVo} 登录vo
     * @return 退出结果
     */
    Result<T> logout(LoginVo loginVo);
}
