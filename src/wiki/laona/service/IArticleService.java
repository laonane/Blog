package wiki.laona.service;

import wiki.laona.domain.Article;

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
}
