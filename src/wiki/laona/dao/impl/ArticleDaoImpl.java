package wiki.laona.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import wiki.laona.dao.IArticleDao;
import wiki.laona.domain.Article;

import java.util.List;

/**
 * @program: Blog
 * @description: 文章 dao 接口实现类
 * @author: HuaiAnGG
 * @create: 2020-11-27 09:36
 **/
public class ArticleDaoImpl extends HibernateDaoSupport implements IArticleDao{
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
}
