package com.qdu.utils;

import com.qdu.pojo.Article;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UploadUtils {
    public static String convertStringtoImage(String encodedImageStr, String userName) {
        String realImagePath = null;
        try {
            // Base64解码图片
            byte[] imageByteArray = Base64.decodeBase64(encodedImageStr);
            String dirPath = "D:/uploadsSpringdd/";
            File dateDir = new File(dirPath);
            if(!dateDir.exists()){
                dateDir.mkdirs();
            }
            realImagePath = userName + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + UUID.randomUUID().toString().replace("-", "") + ".jpg";
            String imagePath = dirPath + realImagePath;
            FileOutputStream imageOutFile = new FileOutputStream(imagePath);
            imageOutFile.write(imageByteArray);
            imageOutFile.close();
            System.out.println("Article Successfully Stored");
        } catch (FileNotFoundException fnfe) {
            System.out.println("Image Path not found" + fnfe);
        } catch (IOException ioe) {
            System.out.println("Exception while converting the Image " + ioe);
        }
        return realImagePath;
    }
}
