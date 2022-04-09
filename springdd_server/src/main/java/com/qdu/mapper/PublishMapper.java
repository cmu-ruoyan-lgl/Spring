package com.qdu.mapper;

import com.qdu.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PublishMapper {
    int addArticle(Article article);
}
