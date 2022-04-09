package com.qdu.algorithm;

import com.qdu.pojo.User;

import java.util.*;
import java.util.stream.Collectors;

public class CollaborativeFiltering {

    public static Map<String, Double> getUserCF(Map<String, Set<String>> userKeywords, String recommendUser, int userNum) {
        //关键字-用户倒排表
        Map<String, Set<String>> keywordsUser = new HashMap<>();
        //每个用户对应的关键字数目，用作相似度计算的分母
        Map<String, Integer> userKeywordsLength = new HashMap<>();
        //用户矩阵
        int[][] userUser = new int[userNum][userNum];
        //用户对应矩阵下标
        Map<String, Integer> userIndex = new HashMap<>();
        //矩阵下标对应用户
        Map<Integer, String> indexUser = new HashMap<>();
        //存储被推荐的用户与其他用户的相似度
        Map<String, Double> userSimilarity = new HashMap<>();
        //初始下标
        int index = 0;
        for (Map.Entry<String, Set<String>> entry : userKeywords.entrySet()) {
            String user = entry.getKey();
            Set<String> keywords = entry.getValue();
            userKeywordsLength.put(user, keywords.size());
            indexUser.put(index, user);
            userIndex.put(user, index++);
            for (String keyword : keywords) {
                if (!keywordsUser.containsKey(keyword)) {
                    keywordsUser.put(keyword, new HashSet<>());
                }
                keywordsUser.get(keyword).add(user);
            }
        }
        //计算用户1与用户2都有正反馈的物品总数,用作相似度计算的分子
        for (Map.Entry<String, Set<String>> entry : keywordsUser.entrySet()) {
            Set<String> userSet = entry.getValue();
            for (String user1 : userSet) {
                for (String user2 : userSet) {
                    if (!user1.equals(user2)) {
                        userUser[userIndex.get(user1)][userIndex.get(user2)]++;
                    }
                }
            }
        }

        int recommendUserIndex = userIndex.get(recommendUser);
        //计算用户之间的相似度：余弦相似度
        for (int i = 0; i < index; i++) {
            if (i != recommendUserIndex) {
                userSimilarity.put(indexUser.get(i),
                        userUser[i][recommendUserIndex]*1.0/Math.sqrt(1.0*userKeywordsLength.get(recommendUser)*userKeywordsLength.get(indexUser.get(i))));
            }
        }
        //对结果从大到小排序
        Map<String, Double> sortResult = userSimilarity.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> newValue,LinkedHashMap::new));
        return sortResult;
    }
}
