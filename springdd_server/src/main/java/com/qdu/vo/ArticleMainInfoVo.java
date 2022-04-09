package com.qdu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleMainInfoVo implements Serializable {
    private int articleId;
    private String imagePath;
    private String content;
}
