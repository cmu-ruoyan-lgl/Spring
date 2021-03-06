package com.qdu.mapper;

import com.qdu.pojo.Article;
import com.qdu.pojo.UserArticle;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleMapper {
    List<Article> queryAllArticle();
    int addRecord(UserArticle userArticle);
}
