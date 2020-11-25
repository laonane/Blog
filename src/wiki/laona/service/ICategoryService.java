package wiki.laona.service;

import wiki.laona.domain.Category;

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
}
