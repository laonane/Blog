package wiki.laona.domain;

/**
 * @program: Blog
 * @description: 文章实体
 * @author: HuaiAnGG
 * @create: 2020-11-27 09:01
 **/
public class Article {

    private Integer articleId;
    private String articleTitle;
    private String articleContext;
    private Long articleTime;
    private String articlePic;
    private String articleDesc;
    /**
     * 外键实体
     */
    private Category category;

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContext='" + articleContext + '\'' +
                ", articleTime=" + articleTime +
                ", articlePic='" + articlePic + '\'' +
                ", articleDesc='" + articleDesc + '\'' +
                ", category=" + category +
                '}';
    }

    public Integer getArticleId() {
        return this.articleId;
    }

    public String getArticleTitle() {
        return this.articleTitle;
    }

    public String getArticleContext() {
        return this.articleContext;
    }

    public Long getArticleTime() {
        return this.articleTime;
    }

    public String getArticlePic() {
        return this.articlePic;
    }

    public String getArticleDesc() {
        return this.articleDesc;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public void setArticleContext(String articleContext) {
        this.articleContext = articleContext;
    }

    public void setArticleTime(Long articleTime) {
        this.articleTime = articleTime;
    }

    public void setArticlePic(String articlePic) {
        this.articlePic = articlePic;
    }

    public void setArticleDesc(String articleDesc) {
        this.articleDesc = articleDesc;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
