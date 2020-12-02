package wiki.laona.web;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @program: Blog
 * @description: 页面转跳action
 * @author: HuaiAnGG
 * @create: 2020-12-02 13:32
 **/
public class LocationAction extends ActionSupport {

    /**
     * 主界面左侧
     *
     * @return 地址
     */
    public String left() {
        return "left";
    }

    /**
     * 主界面顶部
     *
     * @return 地址
     */
    public String top() {
        return "top";
    }

    /**
     * 账号管理
     *
     * @return 地址
     */
    public String account() {
        return "account";
    }

    /**
     * 文章页面添加文章
     * @return 地址
     */
    public String add_article() {
        return  "add_article";
    }
}
