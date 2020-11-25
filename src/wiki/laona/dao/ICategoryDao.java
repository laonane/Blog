package wiki.laona.dao;

import wiki.laona.domain.Category;

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
}
