package wiki.laona.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: Blog
 * @description: 分类实体
 * @author: HuaiAnGG
 * @create: 2020-11-25 20:59
 **/
@Setter
@Getter
public class Category {
    private Integer cid;
    private String cname;
    private Integer parentid;

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", parentid=" + parentid +
                '}';
    }
}
