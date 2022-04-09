package com.qdu.service;

import com.qdu.pojo.Article;
import com.qdu.pojo.UserArticle;

import java.util.List;

public interface ArticleService {
    List<Article> queryAllArticle();
    int addRecord(UserArticle userArticle);
}
