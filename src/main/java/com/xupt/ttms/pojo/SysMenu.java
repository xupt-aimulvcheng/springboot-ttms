package com.xupt.ttms.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Component;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Component
@TableName("system_menu")
public class SysMenu implements Serializable {
  private static final long serialVersionUID = 6649796936885633363L;
  // 复合主键要用这个注解
  @TableId(type = IdType.AUTO)
    private Long id;
    private String href;
    private String title;
    private Long pid;
    private String icon;
    private String target;
    private Integer sort;
    @TableField
    private Boolean status;
    private String remark;
     @CreatedDate
    private Date create_at;
     @CreatedDate
    private Date update_at;
    private Date delete_at;
}