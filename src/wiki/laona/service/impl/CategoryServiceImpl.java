package wiki.laona.service.impl;

import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;
import wiki.laona.dao.ICategoryDao;
import wiki.laona.domain.Category;
import wiki.laona.service.ICategoryService;

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
}
