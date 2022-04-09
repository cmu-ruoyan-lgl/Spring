package com.qdu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {
    private int articleId;
    private String imagePath;
    private String content;
    private String userName;
    private Date articleCreateTime;
    private Date articleModifyTime;

}
