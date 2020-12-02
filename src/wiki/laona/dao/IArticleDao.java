package wiki.laona.dao;

import org.hibernate.criterion.DetachedCriteria;
import wiki.laona.domain.Article;
import wiki.laona.domain.Category;
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

    /**
     * 根据删除文章
     * @param article 文章实体
     */
    void deleteArticleById(Article article);

    /**
     * 根据 id 获取分类信息
     * @param parentId 父类 id
     * @return
     */
    List<Category> getArticleCategory(Integer parentId);

    /**
     * 保存文章到数据库
     * @param article 文章实体
     */
    void saveArticle(Article article);

    /**
     * 获取文章信息
     * @param article 文章实体（包含文章 id）
     * @return 文章实体
     */
    Article getArticle(Article article);

    /**
     * 更新数据库文章信息
     * @param article 文章信息
     */
    void updateArticle(Article article);
}
