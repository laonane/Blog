package wiki.laona.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import wiki.laona.dao.IUserDao;
import wiki.laona.domain.User;

import java.util.List;

/**
 * @program: Blog
 * @description: 用户 dao 接口实现类
 * @author: HuaiAnGG
 * @create: 2020-11-25 11:18
 **/
public class UserDaoImpl extends HibernateDaoSupport implements IUserDao {

    private SessionFactory sessionFactory;

    /**
     * 查询数据库是否有该用户
     * 查询只需要 username 和 password 字段就行，不必把整个 User 也传进来
     *
     * @param username 用户名
     * @param password 密码
     * @return 匹配的用户
     */
    @Override
    public User getUser(String username, String password) {
        // 查询数据库
        // 设置到那个表中去查
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
        // 设置条件
        detachedCriteria.add(Restrictions.eq("username", username));
        detachedCriteria.add(Restrictions.eq("password", password));
        // 断言判断
        assert this.getHibernateTemplate() != null : "getHibernateTemplate is null";
        List<User> userList = (List<User>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        // 判空
        if (userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }
}
