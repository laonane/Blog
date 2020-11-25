package wiki.laona.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import lombok.Setter;
import org.apache.struts2.dispatcher.HttpParameters;
import wiki.laona.domain.Category;
import wiki.laona.service.ICategoryService;

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
     * @return 结果
     */
    public String add(){
        categoryService.save(category);
        return SUCCESS;
    }
}
