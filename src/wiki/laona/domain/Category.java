package wiki.laona.domain;

/**
 * @program: Blog
 * @description: 分类实体
 * @author: HuaiAnGG
 * @create: 2020-11-25 20:59
 **/
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

    public Integer getCid() {
        return this.cid;
    }

    public String getCname() {
        return this.cname;
    }

    public Integer getParentid() {
        return this.parentid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
}
