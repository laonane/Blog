package wiki.laona.boot.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
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

    @TableId
    @TableField(value = "cid")
    private Long id;

    @TableField(value = "cname")
    private String name;

    @TableField(value = "parentid")
    private Long parentId;
}
