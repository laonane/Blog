package wiki.laona.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Setter;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import wiki.laona.domain.Article;
import wiki.laona.domain.Category;
import wiki.laona.domain.PageBean;
import wiki.laona.service.IArticleService;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @program: Blog
 * @description: 文章 action
 * @author: HuaiAnGG
 * @create: 2020-11-27 09:33
 **/
public class ArticleAction extends ActionSupport{

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
     * 上传的文件名
     */
    @Setter
    private String uploadFileName;

    /**
     * 上传的文件
     */
    @Setter
    private File upload;

    /**
     * 上传的文件类型
     */
    @Setter
    private String uploadContentType;

    /**
     * 文章实体
     */

    /**
     * 文章标题
     */
    @Setter
    private String articleTitle;
    /**
     * 文章内容
     */
    @Setter
    private String articleContent;
    /**
     * 文章摘要
     */
    @Setter
    private String articleDesc;
    /**
     * 文章分类 cid
     */
    @Setter
    private Integer categoryCid;
    /**
     * 文章分类 parentId
     */
    @Setter
    private Integer categoryParentId;

    // /**
    //  * 文章实体
    //  */
    // @Setter
    // private Article article;
    //
    // @Override
    // public Article getModel() {
    //     return this.article;
    // }

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
        Article article2 = new Article();
        article2.setArticleId(articleId);
        articleService.deleteArticle(article2);
        return "list_res";
    }


    /**
     * 获取文章父类分类信息
     *
     * @return 文章父类分类信息
     */
    public String getCategory() throws IOException {
        // 根据 parentId 查询分类
        List<Category> categoryList = articleService.getCategory(parentId);
        System.out.println("ArticleAction.getCategory");
        System.out.println("categoryList = " + categoryList);
        // 封装成 json
        JSONArray jsonArray = JSONArray.fromObject(categoryList, new JsonConfig());
        System.out.println("jsonArray = " + jsonArray);
        // 响应给浏览器
        ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
        ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
        return null;
    }

    /**
     * 添加文章
     *
     * @return #
     */
    public String add() throws IOException {
        // 把参数保存到 article 对象中
        Category  category = new Category();
        category.setCid(categoryCid);
        category.setParentid(categoryParentId);

        Article article = new Article();
        article.setArticleTitle(articleTitle);
        article.setArticleContext(articleContent);
        article.setArticleDesc(articleDesc);
        article.setCategory(category);
        // 上传文件
        if (upload != null) {
            // 随机生成文件名称
            // 1. 获取文件扩展名
            int index = uploadFileName.lastIndexOf(".");
            String etx = uploadFileName.substring(index);

            // 2. 生成随机文件名 拼接扩展名
            String uuid = UUID.randomUUID().toString();
            // 去掉 uuid 中的横杠
            String uuidFileName
                    = uuid.replace("-", "") + etx;

            // 确定上传路径
            String path = ServletActionContext.getServletContext().getRealPath("/upload");
            File file = new File(path);
            if (!file.exists()) {
                // 不存在就创建文件路径
                file.mkdirs();
            }
            // 拼接新的文件路径
            File desFile = new File(path + "/" + uuidFileName);
            FileUtils.copyFile(upload, desFile);
            // 设置图片
            article.setArticlePic(uuidFileName);
            // 设置当前时间
            article.setArticleTime(new Date().getTime());
        }
        articleService.save(article);
        return "list_res";
    }

}
