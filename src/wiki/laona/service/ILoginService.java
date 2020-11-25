package wiki.laona.service;

import wiki.laona.domain.User;

/**
 * @program: Blog
 * @description: 登录服务接口
 * @author: HuaiAnGG
 * @create: 2020-11-25 11:05
 **/
public interface ILoginService {

    /**
     * 用户登录
     * @param user 用户
     * @return 查询到的用户实体
     */
    User login(User user);
}
