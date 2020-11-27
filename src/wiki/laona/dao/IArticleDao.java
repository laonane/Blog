package wiki.laona.dao;

import wiki.laona.domain.Article;

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

}
