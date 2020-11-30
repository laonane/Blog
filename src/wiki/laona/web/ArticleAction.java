package wiki.laona.web;

import com.mysql.cj.xdevapi.JsonArray;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Setter;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import wiki.laona.domain.Article;
import wiki.laona.domain.Category;
import wiki.laona.domain.PageBean;
import wiki.laona.service.IArticleService;

import java.io.IOException;
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
     * 分类父级id
     */
    @Setter
    private Integer parentId;

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


    /**
     * 获取文章父类分类信息
     *
     * @return 文章父类分类信息
     */
    public String getCategory() throws IOException {

        // 根据 parentId 查询分类
        List<Category> categoryList = articleService.getCategory(parentId);
        // 封装成 json
        JSONArray jsonArray = JSONArray.fromObject(categoryList, new JsonConfig());
        // 响应给浏览器
        ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
        ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
        return null;
    }
}
