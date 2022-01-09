package wiki.laona.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import wiki.laona.boot.pojo.dao.Category;

/**
 * @author laona
 * @description 分类 mapper 接口
 * @create 2021-07-12 20:54
 **/
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
