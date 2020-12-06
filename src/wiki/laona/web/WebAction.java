package wiki.laona.web;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Setter;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import wiki.laona.domain.Article;
import wiki.laona.domain.PageBean;
import wiki.laona.service.IArticleService;

import java.io.IOException;

/**
 * @program: Blog
 * @description: 前端页面展示 action
 * @author: HuaiAnGG
 * @create: 2020-12-03 15:45
 **/
public class WebAction extends ActionSupport {

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
     * 前端页面获取页面文章数据
     */
    public void getPageList() throws IOException {
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getRequest().setCharacterEncoding("utf-8");
        // 获取数据库文章信息
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Article.class);
        PageBean<Article> pageBean = articleService.getPageData(detachedCriteria, currPage, 5);
        // 返回 json
        JsonConfig jsonConfig = new JsonConfig();
        // 懒加载配置
        jsonConfig.setExcludes(new String[]{"handler", "hibernateLazyInitializer"});
        JSONObject jsonObject = JSONObject.fromObject(pageBean, jsonConfig);
        // 响应给页面
        ServletActionContext.getResponse().getWriter().println(jsonObject.toString());
    }
}
