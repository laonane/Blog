package wiki.laona.boot.pojo.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author laona
 * @description 文章类
 * @create 2021-07-11 22:36
 **/
@Data
@TableName("article")
public class Article{
    /**
     * 博文主键，策略：雪花主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 标题
     */
    private String title;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 创建时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 创建人
     */
    private String createName;
    /**
     * 更新日期
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 更新人
     */
    private String updateName;
    /**
     * 首页略缩图
     */
    private String image;
    /**
     * 文章描述
     */
    private String description;
    /**
     * 删除(逻辑删除)
     */
    @TableLogic
    private Integer deleted;
    /**
     * 分类id
     */
    private BigDecimal cateId;
}
