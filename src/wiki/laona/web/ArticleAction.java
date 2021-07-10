package wiki.laona.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import wiki.laona.domain.Article;
import wiki.laona.domain.Category;
import wiki.laona.domain.PageBean;
import wiki.laona.service.IArticleService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
    private IArticleService articleService;

    /**
     * 当前页码
     */
    private Integer currPage = 1;

    /**
     * 搜索关键字
     */
    private String keyWord;

    /**
     * 删除文章 id
     */
    private Integer articleId;

    /**
     * 分类父级id
     */
    private Integer parentId;

    /**
     * 上传的文件名
     */
    private String uploadFileName;

    /**
     * 上传的文件
     */
    private File upload;

    /**
     * 上传的文件类型
     */
    private String uploadContentType;

    /**
     * 文章实体
     */

    /**
     * 文章标题
     */
    private String articleTitle;
    /**
     * 文章内容
     */
    private String articleContent;
    /**
     * 文章摘要
     */
    private String articleDesc;
    /**
     * 文章分类 cid
     */
    private Integer categoryCid;
    /**
     * 文章分类 parentId
     */
    private Integer categoryParentId;

    /**
     * 修改文章的图片地址
     */
    private String articlePic;

    /**
     * 所有文章数据获取
     *
     * @return 所有文章列表
     */
    public String list() {
        List<Article> articleList = articleService.getAll();
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
        System.out.println("ArticleAction.delete");
        System.out.println("articleId = " + articleId);
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
        // 封装成 json
        JSONArray jsonArray = JSONArray.fromObject(categoryList, new JsonConfig());
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
        Category category = new Category();
        category.setCid(categoryCid);
        category.setParentid(categoryParentId);

        Article article = new Article();
        article.setArticleTitle(articleTitle);
        article.setArticleContext(articleContent);
        article.setArticleDesc(articleDesc);
        article.setCategory(category);
        // 上传文件
        if (upload != null) {
            uploadImage(article);
        }
        articleService.save(article);
        return "list_res";
    }

    /**
     * 文章编辑
     *
     * @return 文章数据
     */
    public String edit() {
        Article article = new Article();
        article.setArticleId(articleId);
        // 查询文章
        Article res = articleService.getArticle(article);
        // System.out.println("res = " + res);
        // 保存文章信息
        ActionContext.getContext().put("res", res);
        return "edit_article";
    }


    /**
     * 更新文章信息
     *
     * @return 文章信息
     */
    public String update() throws IOException {
        // 把参数保存到 article 对象中
        Category category = new Category();
        category.setCid(categoryCid);
        category.setParentid(categoryParentId);

        Article article = new Article();
        article.setArticleId(articleId);
        article.setArticleTitle(articleTitle);
        article.setArticleContext(articleContent);
        article.setArticleDesc(articleDesc);
        // 设置图片
        article.setArticlePic(articlePic);

        article.setCategory(category);
        // 是否已经替换新的图片,如果有就删除原图片
        if (upload != null) {
            String path = ServletActionContext.getServletContext().getRealPath("/upload/");
            String pic_image = articlePic;
            if (!StringUtils.isEmpty(pic_image)) {
                File file = new File(path + "/" + pic_image);
                file.delete();
            }
            this.uploadImage(article);
        }

        // 设置当前时间
        article.setArticleTime(System.currentTimeMillis());

        articleService.update(article);

        return "list_res";
    }


    /**
     * 上传图片
     *
     * @param article 文章实体
     * @throws IOException IO异常
     */
    private void uploadImage(Article article) throws IOException {
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
        String path = ServletActionContext.getServletContext().getRealPath("/upload/");
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
        article.setArticleTime(System.currentTimeMillis());
    }

    public void setArticleService(IArticleService articleService) {
        this.articleService = articleService;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public void setArticleDesc(String articleDesc) {
        this.articleDesc = articleDesc;
    }

    public void setCategoryCid(Integer categoryCid) {
        this.categoryCid = categoryCid;
    }

    public void setCategoryParentId(Integer categoryParentId) {
        this.categoryParentId = categoryParentId;
    }

    public void setArticlePic(String articlePic) {
        this.articlePic = articlePic;
    }
}
