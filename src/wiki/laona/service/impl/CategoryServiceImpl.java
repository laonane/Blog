package wiki.laona.service.impl;

import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;
import wiki.laona.dao.ICategoryDao;
import wiki.laona.domain.Category;
import wiki.laona.service.ICategoryService;

import java.util.List;

/**
 * @program: Blog
 * @description: 分类接口实现类
 * @author: HuaiAnGG
 * @create: 2020-11-26 00:09
 **/
@Transactional
public class CategoryServiceImpl implements ICategoryService {
    @Setter
    private ICategoryDao categoryDao;

    /**
     * 保存分类信息
     *
     * @param category 分类信息
     */
    @Override
    public void save(Category category) {
        categoryDao.saveCategory(category);
    }

    /**
     * 获取所有分类列表
     *
     * @return 分类列表
     */
    @Override
    public List<Category> getAll() {
        List<Category> allCategories = categoryDao.getAllCategories();
        if (allCategories.size() > 0) {
            return allCategories;
        }
        return null;
    }

    /**
     * 通过 cid 查询到该分类数据
     *
     * @param cid 数据 id
     * @return {@linkplain Category} 分类信息
     */
    @Override
    public Category getCategory(Integer cid) {
        return categoryDao.getById(cid);
    }

    /**
     * 更新分类信息
     *
     * @param category 分类实体
     */
    @Override
    public void updateCategory(Category category) {
        categoryDao.updateCategory(category);
    }

    /**
     * 通过 id 删除分类信息
     *
     * @param cid 分类 id
     */
    @Override
    public void deleteCategory(Category category) {
        categoryDao.deleteCategoryById(category);
    }


}
