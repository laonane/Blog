package wiki.laona.dao;

import wiki.laona.domain.Category;

import java.util.List;

/**
 * @program: Blog
 * @description: 分类dao接口
 * @author: HuaiAnGG
 * @create: 2020-11-26 00:11
 **/
public interface ICategoryDao {
    /**
     * 保存分类信息
     * @param category 分类信息
     */
    void saveCategory(Category category);

    /**
     * 获取所有分类信息
     * @return 分类列表
     */
    List<Category> getAllCategories();

    /**
     * 查询分类信息
     * @param cid 分类 id
     * @return 分类信息
     */
    Category getById(Integer cid);

    /**
     * 更新分类信息
     * @param category 分类实体
     */
    void updateCategory(Category category);

    /**
     * 通过 id 删除分类信息
     * @param category 分类实体
     */
    void deleteCategoryById(Category category);
}
