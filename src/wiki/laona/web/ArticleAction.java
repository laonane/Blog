package wiki.laona.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Setter;
import org.hibernate.criterion.DetachedCriteria;
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
     * 所有文章数据获取
     *
     * @return 所有文章列表
     *
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
        System.out.println("ArticleAction.pageList");
        System.out.println("currPage = " + currPage);
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Article.class);
        PageBean<Article> pageBean = articleService.getPageData(detachedCriteria, currPage, 5);
        ActionContext.getContext().put("pageBean", pageBean);
        return "list";
    }
}
