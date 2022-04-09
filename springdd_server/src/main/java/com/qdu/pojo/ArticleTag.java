package com.qdu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleTag implements Serializable {
    private int tagId;
    private int articleId;
    private Date articleTagCreateTime;
    private Date articleTagModifyTime;
}
