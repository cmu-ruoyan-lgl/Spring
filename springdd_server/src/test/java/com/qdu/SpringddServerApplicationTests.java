package com.qdu;

import com.qdu.pojo.Tag;
import com.qdu.service.TagService;
import com.qdu.utils.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.qdu.algorithm.*;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class SpringddServerApplicationTests {

    @Autowired
    private TagService tagService;

    @Test
    void TextRankKeywordTest() {
        String s = "程序员(英文Programmer)是从事程序开发、维护的专业人员。一般将程序员分为程序设计人员和程序编码人员，但两者的界限并不非常清楚，特别是在中国。软件从业人员分为初级程序员、高级程序员、系统分析员和项目经理四大类。";
        System.out.println(TextRankKeyword.wordSegmentation(s));
        List<String> list = new ArrayList<>();
        for (String s1 : StringUtils.splitWord(s)) {
            list.addAll(TextRankKeyword.wordSegmentation(StringUtils.removeNotCHNWords(s1)));
        }
        List<String> collect = list.stream().filter(s1 -> s1.length() > 1).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(TextRankKeyword.getTextRank(collect, 5));
    }

    @Test
    void userCFTest() {
        int userNum = 4;
        String recommendUser = "A";
        Map<String, Set<String>> userKeywords = new HashMap<>();
        Set<String> A = new HashSet<>();
        A.add("a");
        A.add("b");
        A.add("d");
        userKeywords.put("A", A);

        Set<String> B = new HashSet<>();
        B.add("a");
        B.add("c");
        userKeywords.put("B", B);

        Set<String> C = new HashSet<>();
        C.add("b");
        C.add("e");
        userKeywords.put("C", C);

        Set<String> D = new HashSet<>();
        D.add("c");
        D.add("d");
        D.add("e");
        userKeywords.put("D", D);

        Map<String, Double> userCF = CollaborativeFiltering.getUserCF(userKeywords, recommendUser, userNum);
        System.out.println(userCF);
    }

    @Test
    void RandomWalkTest() {
        String recommendUser = "CU";
        Map<String, Set<String>> userArticle = new HashMap<>();
        Set<String> CU = new HashSet<>();
        CU.add("Item2");
        CU.add("Item4");
        CU.add("Item5");
        CU.add("Item6");
        userArticle.put("CU", CU);

        Set<String> User1 = new HashSet<>();
        User1.add("Item1");
        User1.add("Item2");
        User1.add("Item4");
        User1.add("Item6");
        userArticle.put("User1", User1);

        Set<String> User2 = new HashSet<>();
        User2.add("Item3");
        User2.add("Item5");
        User2.add("Item6");
        userArticle.put("User2", User2);

        Set<String> User3 = new HashSet<>();
        User3.add("Item1");
        User3.add("Item2");
        User3.add("Item3");
        User3.add("Item4");
        User3.add("Item5");
        User3.add("Item6");
        userArticle.put("User3", User3);

        Map<String, Double> article = RandomWalk.getArticle(userArticle, recommendUser);
        System.out.println(article);
    }

    @Test
    void insertTxtTags() throws IOException {
        File file = new File("C:\\Users\\lenovo\\Downloads\\sentiment\\fp.txt");
        String encoding = "GBK";
        InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt = null;
        List<Tag> tags = new ArrayList<>();
        while ((lineTxt = bufferedReader.readLine()) != null) {
            Tag tag = new Tag();
            tag.setTagName(lineTxt);
            Date date = new Date();
            tag.setTagCreateTime(date);
            tag.setTagModifyTime(date);
            tags.add(tag);
        }
        tagService.insertTags(tags);
        read.close();
    }

    @Test
    void insertExcelTags() throws IOException {
        Workbook workbook = new XSSFWorkbook("C:\\Users\\lenovo\\Desktop\\情感词汇本体\\情感词汇本体.xlsx");
        Sheet sheet = workbook.getSheetAt(0);
        //最大行
        int maxRow = sheet.getPhysicalNumberOfRows();
        //去第一列的列数作为最大列
        int maxCol = sheet.getRow(0).getPhysicalNumberOfCells();
        List<Tag> tags = new ArrayList<>();
        for (int i = 1; i < maxRow; i++) {
            Row row = sheet.getRow(i);
            Tag tag = new Tag();
            for (int j = 0; j < maxCol; j++) {
                Cell cell = row.getCell(j);
                if (j == 0) {
                    tag.setTagName(cell.toString());
                }
                if (j == 6) {
                    tag.setTagSex((int) Double.parseDouble(cell.toString()));
                    Date date = new Date();
                    tag.setTagCreateTime(date);
                    tag.setTagModifyTime(date);
                    tags.add(tag);
                }
            }
        }
        tagService.insertTags(tags);
    }

}
