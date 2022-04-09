package com.qdu.controller;

import com.qdu.enums.PublishEnum;
import com.qdu.service.PublishService;
import com.qdu.utils.FillUtils;
import com.qdu.utils.UploadUtils;
import com.qdu.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishController {

    final String imageUrl = "http://192.168.1.3:7001/images/";

    @Autowired
    private PublishService publishService;

    @PostMapping("/publishArticle")
    public String publishArticle(@RequestBody ArticleVo articleVo){
        articleVo.setImagePath(imageUrl+UploadUtils.convertStringtoImage(articleVo.getImage(), articleVo.getToken()));
        publishService.addArticle(FillUtils.articleFill(articleVo));
        return PublishEnum.PUBLISH_SUCCESS.toString();
    }

}
