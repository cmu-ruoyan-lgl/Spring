package com.qdu.service.impl;

import com.qdu.mapper.PublishMapper;
import com.qdu.pojo.Article;
import com.qdu.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishServiceImpl implements PublishService {

    @Autowired
    private PublishMapper publishMapper;

    @Override
    public int addArticle(Article article) {
        return publishMapper.addArticle(article);
    }
}
