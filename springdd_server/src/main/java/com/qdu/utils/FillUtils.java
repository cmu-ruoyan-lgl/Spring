package com.qdu.utils;

import com.qdu.enums.UserStateEnum;
import com.qdu.pojo.Article;
import com.qdu.pojo.User;
import com.qdu.pojo.UserArticle;
import com.qdu.pojo.UserState;
import com.qdu.vo.ArticleMainInfoVo;
import com.qdu.vo.ArticleVo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FillUtils {

    public static User userFill(User user){
        user.setUserPhone("15275631629");
        user.setUserEmail("1429277983@qq.com");
        Date date = new Date();
        user.setUserCreateTime(date);
        user.setUserModifyTime(date);
        System.out.println(user);
        return user;
    }

    public static UserState userStateFill(User user){
        return new UserState(user.getUserId(), UserStateEnum.NORMAL.toString(),user.getUserCreateTime(),user.getUserCreateTime());
    }

    public static Article articleFill(ArticleVo articleVo){
        Article article = new Article();
        article.setUserName(articleVo.getToken());
        article.setImagePath(articleVo.getImagePath());
        article.setContent(articleVo.getContent());
        Date date = new Date();
        article.setArticleCreateTime(date);
        article.setArticleModifyTime(date);
        return article;
    }

    public static List<ArticleMainInfoVo> articleMainInfoVoFill(List<Article> articles){
        List<ArticleMainInfoVo> articleMainInfoVos = new ArrayList<>();
        for (Article article : articles) {
            ArticleMainInfoVo articleMainInfoVo = new ArticleMainInfoVo();
            articleMainInfoVo.setContent(article.getContent());
            articleMainInfoVo.setImagePath(article.getImagePath());
            articleMainInfoVo.setArticleId(article.getArticleId());
            articleMainInfoVos.add(articleMainInfoVo);
        }
        return articleMainInfoVos;
    }

    public static UserArticle userArticleFill(UserArticle userArticle){

        Date date = new Date();
        userArticle.setUserArticleCreateTime(date);
        userArticle.setUserArticleModifyTime(date);
        return userArticle;
    }
}
