package com.qdu.algorithm;

import com.huaban.analysis.jieba.JiebaSegmenter;

import java.util.*;
import java.util.stream.Collectors;

public class TextRankKeyword {
    private static JiebaSegmenter jiebaSegmenter = new JiebaSegmenter();
    //阻尼系数，一般取值为0.85
    final static double d = 0.85;
    //最大迭代次数
    final static int maxIter = 200;
    //最小区别值，当收敛程度小于这个值结束迭代
    final static double minDiff = 0.001;

    public static List<String> wordSegmentation(String article) {
        return jiebaSegmenter.sentenceProcess(article);
    }

    public static Map<String, Double> getTextRank(List<String> keywords, int windowSize) {
        //词和对应的邻居们建的边
        Map<String, Set<String>> wordToWords = new HashMap<>();
        //滑动窗口
        Queue<String> window = new LinkedList<>();
        for (String keyword : keywords) {
            if (!wordToWords.containsKey(keyword)) {
                wordToWords.put(keyword, new HashSet<>());
            }
            if (window.size() >= windowSize){
                window.poll();
            }
            for (String item : window) {
                if(keyword.equals(item)){
                    continue;
                }
                //建立双向边
                wordToWords.get(keyword).add(item);
                wordToWords.get(item).add(keyword);
            }
            window.add(keyword);
        }
        //迭代结果
        Map<String,Double> result = new HashMap<>();
        for (int i = 0; i < maxIter; i++){
            //迭代一次的结果
            Map<String,Double> resultOne = new HashMap<>();
            //迭代一次中相差的最大值
            double maxDiff = 0;
            for (Map.Entry<String,Set<String>> entry : wordToWords.entrySet()){
                String key = entry.getKey();
                Set<String> value = entry.getValue();
                resultOne.put(key,1-d);
                for (String val : value) {
                    int outSize = wordToWords.get(val).size();
                    if(outSize == 0){
                        continue;
                    }
                    resultOne.put(key,resultOne.get(key)+d/outSize*(result.get(val) == null ? 0:result.get(val)));
                }
                maxDiff = Math.max(maxDiff,Math.abs(resultOne.get(key) - (result.get(key) == null ? 0: result.get(key))));
            }
            result = resultOne;
            if(maxDiff <= minDiff){
                break;
            }
        }
        //对结果从大到小排序
        Map<String, Double> sortResult = result.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> newValue,LinkedHashMap::new));
        return sortResult;
    }

}
