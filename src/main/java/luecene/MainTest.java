package luecene;

import com.hankcs.hanlp.HanLP;

import java.util.List;

public class MainTest {
    public static void main(String[] args) {

        String content = "为什么晚上不能照镜子";

        List<String> keywordList = HanLP.extractKeyword(content, 5);

        System.out.println(keywordList);

        }
    }
