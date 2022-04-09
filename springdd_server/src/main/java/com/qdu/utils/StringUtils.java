package com.qdu.utils;

public class StringUtils {

    final static String splitWordRegex = "[，。！；？：《》{}【】‘’“”、]";
    final static String removeNotCHNWordsRegex = "[^\\u4e00-\\u9fa5]";

    //对文章进行分割，防止直接分割导致词语的重组
    public static String [] splitWord(String s){
        return s.split(splitWordRegex);
    }

    //去除不是中文的字符
    public static String removeNotCHNWords(String s){
        return s.replaceAll(removeNotCHNWordsRegex,"");
    }
}
