package wiki.laona.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import wiki.laona.boot.pojo.dao.Customer;

/**
 * @author laona
 * @description 用户 mapper 接口
 * @create 2021-07-12 20:55
 **/
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
}
