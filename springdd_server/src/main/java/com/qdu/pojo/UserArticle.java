package com.qdu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserArticle implements Serializable {
    private int userId;
    private int articleId;
    private Date userArticleCreateTime;
    private Date userArticleModifyTime;
}
