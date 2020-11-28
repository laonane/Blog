package wiki.laona.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Setter;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import wiki.laona.domain.Article;
import wiki.laona.domain.PageBean;
import wiki.laona.service.IArticleService;

import java.util.List;

/**
 * @program: Blog
 * @description: 文章 action
 * @author: HuaiAnGG
 * @create: 2020-11-27 09:33
 **/
public class ArticleAction extends ActionSupport {

    /**
     * 文章服务接口
     */
    @Setter
    private IArticleService articleService;

    /**
     * 当前页码
     */
    @Setter
    private Integer currPage = 1;

    /**
     * 搜索关键字
     */
    @Setter
    private String keyWord;

    /**
     * 删除文章 id
     */
    @Setter
    private Integer articleId;

    /**
     * 所有文章数据获取
     *
     * @return 所有文章列表
     */
    public String list() {
        System.out.println("ArticleAction.list");
        List<Article> articleList = articleService.getAll();
        System.out.println("articleList = " + articleList);
        ActionContext.getContext().put("articleList", articleList);
        return "list";
    }

    /**
     * 分页数据获取
     *
     * @return 当前页的所有数据信息
     */
    public String pageList() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Article.class);
        if (keyWord != null) {
            // 模糊查询
            detachedCriteria.add(Restrictions.like("articleTitle", "%" + keyWord + "%"));
        }
        PageBean<Article> pageBean = articleService.getPageData(detachedCriteria, currPage, 5);
        ActionContext.getContext().put("pageBean", pageBean);
        return "list";
    }


    /**
     * 删除文章
     *
     * @return 删除后的文章列表
     */
    public String delete() {
        Article article = new Article();
        article.setArticleId(articleId);
        articleService.deleteArticle(article);
        return "delete_article";
    }
}
