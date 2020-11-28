package wiki.laona.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import wiki.laona.dao.IArticleDao;
import wiki.laona.domain.Article;
import wiki.laona.domain.PageBean;

import java.util.List;

/**
 * @program: Blog
 * @description: 文章 dao 接口实现类
 * @author: HuaiAnGG
 * @create: 2020-11-27 09:36
 **/
public class ArticleDaoImpl extends HibernateDaoSupport implements IArticleDao {
    /**
     * 获取所有文章列表
     *
     * @return 文章列表
     */
    @Override
    public List<Article> getAllArticle() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Article.class);
        return (List<Article>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
    }

    /**
     * 从数据库获取分页文章数据
     *
     * @param detachedCriteria QDL 查询条件
     * @param currPage         当前页码
     * @param pageSize         一页有多少条数据
     * @return 分页文章数据
     */
    @Override
    public PageBean<Article> getPageArticle(DetachedCriteria detachedCriteria, Integer currPage, int pageSize) {
        this.getHibernateTemplate().findByCriteria(detachedCriteria);
        return null;
    }

    /**
     * 获取总记录数
     *
     * @param detachedCriteria 查询条件
     * @return 总记录数
     */
    @Override
    public Integer getTotalCount(DetachedCriteria detachedCriteria) {
        detachedCriteria.setProjection(null);
        // 设置查询条件
        // Projections.rowCount() 总行数
        detachedCriteria.setProjection(Projections.rowCount());
        List<Long> totalCount = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        if (totalCount.size() > 0) {
            return totalCount.get(0).intValue();
        }
        return 0;
    }

    /**
     * 获取当前页的所有数据
     *
     * @param detachedCriteria 查询条件
     * @param index            计算当前页从数据库当中查询的位置（角标）
     * @param pageSize         当前页的记录数
     * @return 当前页的所有文章数据
     */
    @Override
    public List<Article> getPageData(DetachedCriteria detachedCriteria, Integer index, Integer pageSize) {
        // detachedCriteria 中在获取总记录数的时候 设置了条件，需要重置一下这个查询条件
        detachedCriteria.setProjection(null);
        return (List<Article>) this.getHibernateTemplate().findByCriteria(detachedCriteria, index , pageSize);
    }

    /**
     * 根据删除文章
     *
     * @param article 文章实体
     */
    @Override
    public void deleteArticleById(Article article) {
        this.getHibernateTemplate().delete(article);
    }

}
