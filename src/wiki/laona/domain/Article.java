package wiki.laona.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: Blog
 * @description: 文章实体
 * @author: HuaiAnGG
 * @create: 2020-11-27 09:01
 **/
@Setter
@Getter
public class Article {

    private Integer articleId;
    private String articleTitle;
    private String articleContext;
    private Integer articleTime;
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
                // ", category=" + category +
                '}';
    }
}
