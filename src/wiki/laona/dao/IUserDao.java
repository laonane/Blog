package wiki.laona.dao;

import wiki.laona.domain.User;

/**
 * @program: Blog
 * @description: 用户 dao 接口
 * @author: HuaiAnGG
 * @create: 2020-11-25 11:17
 **/
public interface IUserDao {

    /**
     * 查询数据库是否有该用户
     * 查询只需要 username 和 password 字段就行，不必把整个 User 也传进来
     *
     * @param username 用户名
     * @param password 密码
     * @return 匹配的用户
     */
    User getUser(String username, String password);
}
