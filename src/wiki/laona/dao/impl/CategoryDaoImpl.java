package wiki.laona.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import wiki.laona.dao.ICategoryDao;
import wiki.laona.domain.Category;

/**
 * @program: Blog
 * @description: 分类dao接口实现类
 * @author: HuaiAnGG
 * @create: 2020-11-26 00:11
 **/
public class CategoryDaoImpl extends HibernateDaoSupport implements ICategoryDao {

    /**
     * 保存分类信息
     *
     * @param category 分类信息
     */
    @Override
    public void saveCategory(Category category) {
        System.out.println("category = " + category);
        this.getHibernateTemplate().save(category);
    }
}
