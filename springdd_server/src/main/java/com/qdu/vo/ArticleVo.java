package com.qdu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleVo implements Serializable {

    private String image;
    private String imagePath;
    private String content;
    private String token;

}
