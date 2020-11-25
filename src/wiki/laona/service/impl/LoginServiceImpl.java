package wiki.laona.service.impl;

import wiki.laona.dao.IUserDao;
import wiki.laona.domain.User;
import wiki.laona.service.ILoginService;

/**
 * @program: Blog
 * @description: 登录服务接口实现类
 * @author: HuaiAnGG
 * @create: 2020-11-25 11:06
 **/
public class LoginServiceImpl implements ILoginService {

    /**
     * user dao
     */
    private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 用户登录
     *
     * @param user 用户
     */
    @Override
    public User login(User user) {
        return userDao.getUser(user.getUsername(), user.getPassword());
    }
}
