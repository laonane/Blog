package wiki.laona.boot.pojo.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author laona
 * @description 分类
 * @create 2021-07-11 22:43
 **/
@Data
@TableName("category")
public class Category {
    /**
     * 分类id，策略：雪花主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private String name;

    private String parentId;
}
