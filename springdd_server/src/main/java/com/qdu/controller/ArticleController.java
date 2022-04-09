package com.qdu.controller;

import com.google.gson.Gson;
import com.qdu.pojo.Article;
import com.qdu.pojo.UserArticle;
import com.qdu.service.ArticleService;
import com.qdu.service.UserService;
import com.qdu.utils.FillUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @RequestMapping("/queryArticleList")
    public String queryArticleList(HttpServletRequest request) {
        List<Article> articles = articleService.queryAllArticle();
        Gson gson = new Gson();
        return gson.toJson(FillUtils.articleMainInfoVoFill(articles));
    }

    @PostMapping("/insertRecord")
    public void insertRecord(HttpServletRequest request,@RequestBody UserArticle userArticle) {
        String userName = request.getHeader("token");
        userArticle.setUserId(userService.queryUserByUserName(userName).getUserId());
        //System.out.println(FillUtils.userArticleFill(userArticle));
        articleService.addRecord(FillUtils.userArticleFill(userArticle));
    }
}
