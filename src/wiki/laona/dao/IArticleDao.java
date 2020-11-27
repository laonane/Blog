package wiki.laona.dao;

import org.hibernate.criterion.DetachedCriteria;
import wiki.laona.domain.Article;
import wiki.laona.domain.PageBean;

import java.util.List;

/**
 * @program: Blog
 * @description: 文章 dao 接口
 * @author: HuaiAnGG
 * @create: 2020-11-27 09:34
 **/
public interface IArticleDao {

    /**
     * 获取所有文章列表
     *
     * @return 文章列表
     */
    List<Article> getAllArticle();

    /**
     * 从数据库获取分页文章数据
     *
     * @param detachedCriteria QDL 查询条件
     * @param currPage         当前页码
     * @param pageSize         一页有多少条数据
     * @return 分页文章数据
     */
    PageBean<Article> getPageArticle(DetachedCriteria detachedCriteria, Integer currPage, int pageSize);

    /**
     * 获取总记录数
     *
     * @param detachedCriteria 查询条件
     * @return 总记录数
     */
    Integer getTotalCount(DetachedCriteria detachedCriteria);

    /**
     * 获取当前页的所有数据
     *
     * @param detachedCriteria 查询条件
     * @param index            计算当前页从数据库当中查询的位置（角标）
     * @param pageSize         当前页的记录数
     * @return 当前页的所有文章数据
     */
    List<Article> getPageData(DetachedCriteria detachedCriteria, Integer index, Integer pageSize);
}
