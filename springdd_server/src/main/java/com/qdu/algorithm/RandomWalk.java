package com.qdu.algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class RandomWalk {

    public static Map<String, Double> getArticle(Map<String, Set<String>> userArticle, String recommendUser) {
        //用户集合
        List<String> userList = new ArrayList<>();
        //文章集合
        Set<String> articleSet = new HashSet<>();
        for (Map.Entry<String, Set<String>> entry : userArticle.entrySet()) {
            userList.add(entry.getKey());
            articleSet.addAll(entry.getValue());
        }
        //用户-文章矩阵
        int[][] userArticleMatrix = new int[userList.size()][articleSet.size()];
        //用户下标
        Map<String, Integer> userIndex = new HashMap<>();
        //文章下标
        Map<String, Integer> articleIndex = new HashMap<>();
        //初始下标
        int index = 0;
        for (String user : userList) {
            userIndex.put(user, index++);
        }
        //更新初始下表
        index = 0;
        for (String article : articleSet) {
            articleIndex.put(article, index++);
        }
        //文章对应用户
        Map<String, Set<String>> articleUser = new HashMap<>();
        //生成用户-文章矩阵 和  文章对应的看过的用户
        for (String user : userList) {
            for (String article : articleSet) {
                if (userArticle.get(user).contains(article)) {
                    userArticleMatrix[userIndex.get(user)][articleIndex.get(article)] = 1;
                } else {
                    userArticleMatrix[userIndex.get(user)][articleIndex.get(article)] = 0;
                }
                if (!userArticle.get(user).contains(article)) {
                    continue;
                }
                if (articleUser.containsKey(article)) {
                    articleUser.get(article).add(user);
                } else {
                    Set<String> userSet = new HashSet<>();
                    userSet.add(user);
                    articleUser.put(article, userSet);
                }
            }
        }
        //概率表
        double[][] articleArticle = new double[articleSet.size()][articleSet.size()];
        //计算概率表 article1-article2 选了article2选article1的概率
        for (String article1 : articleSet) {
            for (String article2 : articleSet) {
                double sum = 0;
                for (String user : userList) {
                    sum += 1.0 * userArticleMatrix[userIndex.get(user)][articleIndex.get(article1)] * userArticleMatrix[userIndex.get(user)][articleIndex.get(article2)] / userArticle.get(user).size();
                }
                articleArticle[articleIndex.get(article1)][articleIndex.get(article2)] = sum / articleUser.get(article2).size();
            }
        }
        //被推荐用户看没看过的文章的理论概率
        Map<String, Double> articleProbability = new HashMap<>();
        //计算被推荐用户选择他没看过的文章的概率
        for (String article : articleSet) {
            if (!userArticle.get(recommendUser).contains(article)) {
                double fenZi = 0, fenMu = 0;
                for (String article1 : articleSet) {
                    fenZi += 1.0 * articleArticle[articleIndex.get(article)][articleIndex.get(article1)] * userArticleMatrix[userIndex.get(recommendUser)][articleIndex.get(article1)];
                    fenMu += 1.0 * articleArticle[articleIndex.get(article)][articleIndex.get(article1)];
                }
                articleProbability.put(article, fenZi / fenMu);
            }
        }
        //对结果从大到小排序
        Map<String, Double> sortResult = articleProbability.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> newValue, LinkedHashMap::new));
        return sortResult;
    }


}
