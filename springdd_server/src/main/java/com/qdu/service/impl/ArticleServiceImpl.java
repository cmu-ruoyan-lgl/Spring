package com.qdu.service.impl;

import com.qdu.mapper.ArticleMapper;
import com.qdu.pojo.Article;
import com.qdu.pojo.UserArticle;
import com.qdu.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> queryAllArticle() {
        return articleMapper.queryAllArticle();
    }

    @Override
    public int addRecord(UserArticle userArticle) {
        return articleMapper.addRecord(userArticle);
    }
}
