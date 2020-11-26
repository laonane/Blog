package wiki.laona.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import wiki.laona.dao.ICategoryDao;
import wiki.laona.domain.Category;

import java.util.List;

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
        assert this.getHibernateTemplate() != null;
        this.getHibernateTemplate().save(category);
    }

    /**
     * 获取所有分类信息
     *
     * @return 分类列表
     */
    @Override
    public List<Category> getAllCategories() {
        System.out.println("CategoryDaoImpl.getAllCategories");
        // 使用 dql
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Category.class);
        List<Category> categoryList = (List<Category>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        return categoryList;
    }

    /**
     * 查询分类信息
     *
     * @param cid 分类 id
     * @return 分类信息
     */
    @Override
    public Category getById(Integer cid) {
        System.out.println("CategoryDaoImpl.getById");
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Category.class);
        detachedCriteria.add(Restrictions.eq("cid", cid));
        List<Category> categoryList = (List<Category>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        System.out.println("categoryList = " + categoryList);
        if (categoryList.size() > 0) {
            return categoryList.get(0);
        }
        return null;
    }

    /**
     * 更新分类信息
     *
     * @param category 分类实体
     */
    @Override
    public void updateCategory(Category category) {
        System.out.println("CategoryDaoImpl.updateCategory");
        this.getHibernateTemplate().update(category);
    }

    /**
     * 通过 id 删除分类信息
     *
     * @param cid 分类信息 cid
     */
    @Override
    public void deleteCategoryById(Category category) {
        System.out.println("CategoryDaoImpl.deleteCategoryById");
        this.getHibernateTemplate().delete(category);
    }


}
