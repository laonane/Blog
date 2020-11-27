package wiki.laona.service.impl;

import lombok.Setter;
import wiki.laona.dao.IArticleDao;
import wiki.laona.domain.Article;
import wiki.laona.service.IArticleService;

import java.util.List;

/**
 * @program: Blog
 * @description: 文章服务接口实现类
 * @author: HuaiAnGG
 * @create: 2020-11-27 09:38
 **/
public class ArticleServiceImpl implements IArticleService {

    @Setter
    private IArticleDao articleDao;

    /**
     * 获取所有文章信息
     *
     * @return 文章列表
     */
    @Override
    public List<Article> getAll() {
        return articleDao.getAllArticle();
    }
}
