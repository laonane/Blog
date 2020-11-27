package wiki.laona.service.impl;

import com.sun.corba.se.impl.oa.toa.TOA;
import lombok.Setter;
import org.hibernate.criterion.DetachedCriteria;
import wiki.laona.dao.IArticleDao;
import wiki.laona.domain.Article;
import wiki.laona.domain.PageBean;
import wiki.laona.service.IArticleService;

import java.util.List;

/**
 * @program: Blog
 * @description: 文章服务接口实现类
 * @author: HuaiAnGG
 * @create: 2020-11-27 09:38
 **/
public class ArticleServiceImpl<articlePageBean> implements IArticleService {

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

    /**
     * 获取分页数据
     *
     * @param detachedCriteria QDL查询条件
     * @param currPage         当前页
     * @param pageSize         一页多少条数据
     * @return 分页数据
     */
    @Override
    public PageBean<Article> getPageData(DetachedCriteria detachedCriteria, Integer currPage, int pageSize) {
        PageBean<Article> pageBean = new PageBean<>();
        // 设置当前页
        pageBean.setCurrentPage(currPage);
        // 设置一页有多少条数据
        pageBean.setPageSize(pageSize);
        // 从数据库获取总记录数
        Integer totalCount = articleDao.getTotalCount(detachedCriteria);
        // 设置总记录数
        pageBean.setTotalCount(totalCount);
        // 设置总页数
        pageBean.setTotalPage(pageBean.getTotalPage());
        // 查询数据库，设置当前页数据
        List<Article> pageArticle =  articleDao.getPageData(detachedCriteria, pageBean.getIndex(), pageBean.getPageSize());
        // 计算
        pageBean.setList(pageArticle);
        System.out.println("pageBean = " + pageBean);
        return pageBean;
    }
}
