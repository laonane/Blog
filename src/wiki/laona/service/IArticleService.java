package wiki.laona.service;

import org.hibernate.criterion.DetachedCriteria;
import wiki.laona.domain.Article;
import wiki.laona.domain.Category;
import wiki.laona.domain.PageBean;

import java.util.List;

/**
 * @program: Blog
 * @description: 文章服务的接口
 * @author: HuaiAnGG
 * @create: 2020-11-27 09:37
 **/
public interface IArticleService {

    /**
     * 获取所有文章信息
     * @return 文章列表
     */
    List<Article> getAll();

    /**
     * 获取分页数据
     * @param detachedCriteria QDL查询条件
     * @param currPage 当前页
     * @param pageSize 一页多少条数据
     * @return 分页数据列表
     */
    PageBean<Article> getPageData(DetachedCriteria detachedCriteria, Integer currPage, int pageSize);

    /**
     * 删除文章信息
     * @param article 文章实体(包含 id )
     */
    void deleteArticle(Article article);

    /**
     * 根据 parentId 查询文章分类
     * @param parentId 文章父类 id
     * @return 分类信息
     */
    List<Category> getCategory(Integer parentId);

    /**
     * 保存文章
     * @param article 文章实体
     */
    void save(Article article);
}
