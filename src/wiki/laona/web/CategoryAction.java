package wiki.laona.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import lombok.Setter;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import wiki.laona.domain.Category;
import wiki.laona.service.ICategoryService;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.List;

/**
 * @program: Blog
 * @description: 分类 action
 * @author: HuaiAnGG
 * @create: 2020-11-26 00:06
 **/
public class CategoryAction extends ActionSupport implements ModelDriven<Category> {

    private Category category = new Category();
    @Setter
    private ICategoryService categoryService;

    @Override
    public Category getModel() {
        return this.category;
    }

    /**
     * 添加分类
     *
     * @return 结果
     */
    public String add() {
        categoryService.save(category);
        return "list_action";
    }

    public String list() {
        System.out.println("CategoryAction.list");
        List<Category> categoryList = categoryService.getAll();
        System.out.println("categoryList = " + categoryList);
        /**
         * 把数据存到值栈当中，集合用 set， 对象用 push
         */
        ActionContext.getContext().put("categoryList", categoryList);
        return "category_list";
    }

    /**
     * 更新界面
     * cid 会通过 ModelDriven 自动保存到 category.cid 中
     *
     * @return 返回分类 json 数据
     */
    public String updateUI() throws IOException {
        Integer cid = category.getCid();
        Category getCategory = categoryService.getCategory(cid);
        System.out.println("CategoryAction.updateUI");
        System.out.println("getCategory = " + getCategory);
        // 格式化 json
        JSONArray jsonArray = JSONArray.fromObject(getCategory, new JsonConfig());
        // 相应到页面
        ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
        ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
        return null;
    }

    /**
     * 更新分类数据
     * @return 成功
     */
    public String update() {
        System.out.println("CategoryAction.update");
        categoryService.updateCategory(category);
        return "list_action";
    }

    public String delete() {
        System.out.println("CategoryAction.delete");
        System.out.println("category = " + category);
        categoryService.deleteCategory(category);
        return "list_action";
    }
}
