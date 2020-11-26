package wiki.laona.service;

import wiki.laona.domain.Category;

import java.util.List;

/**
 * @program: Blog
 * @description: 分类服务接口
 * @author: HuaiAnGG
 * @create: 2020-11-26 00:07
 **/
public interface ICategoryService {

    /**
     * 保存分类信息
     * @param category 分类信息
     */
    void save(Category category);

    /**
     * 获取所有分类列表
     * @return 分类列表
     */
    List<Category> getAll();

    /**
     * 通过 cid 查询到该分类数据
     * @param cid 数据 id
     * @return {@linkplain Category} 分类信息
     */
    Category getCategory(Integer cid);

    /**
     * 更新分类信息
     * @param category 分类实体
     */
    void updateCategory(Category category);

    /**
     * 通过 id 删除分类信息
     * @param category 分类实体
     */
    void deleteCategory(Category category);
}
