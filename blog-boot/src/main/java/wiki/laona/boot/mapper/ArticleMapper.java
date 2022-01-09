package wiki.laona.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import wiki.laona.boot.pojo.dao.Article;

/**
 * @author laona
 * @description
 * @create 2021-07-11 22:35
 **/
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
