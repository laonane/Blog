package wiki.laona.web;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Setter;
import wiki.laona.domain.Article;
import wiki.laona.service.IArticleService;

import java.util.List;

/**
 * @program: Blog
 * @description: 文章 action
 * @author: HuaiAnGG
 * @create: 2020-11-27 09:33
 **/
public class ArticleAction extends ActionSupport {

    @Setter
    private IArticleService articleService;

    public String list() {
        System.out.println("ArticleAction.list");
        List<Article> articleList = articleService.getAll();
        System.out.println("articleList = " + articleList);
        return null;
    }
}
