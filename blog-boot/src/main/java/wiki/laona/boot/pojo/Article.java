package wiki.laona.boot.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Data;

import java.security.Timestamp;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author laona
 * @description 文章类
 * @create 2021-07-11 22:36
 **/
@Data
@TableName("article")
public class Article{

    @TableId(value = "article_id")
    private Long id;

    @TableField(value = "article_title")
    private String title;

    @TableField(value = "article_context")
    private String context;

    @TableField(value = "article_time")
    // @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @TableField(value = "article_pic")
    private String pic;

    @TableField(value = "article_desc")
    private String description;

    @TableField(value = "article_cid")
    private Long cid;

    public void setCreateTime(Long createTime) {
        this.createTime = new Date(createTime);
    }
}
