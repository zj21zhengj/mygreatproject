package luecene;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;

import java.util.List;

public class WordFilter {

    public static  void automaticSelection(String title,long a) {
        //移除停用词进行分词
        List<Word> list = WordSegmenter.seg(title);
        System.out.println("111111111");
        System.out.println(list);

        long b = System.currentTimeMillis();
        System.out.println(b - a);
        //保留停用词
        /*List<Word> lists = WordSegmenter.segWithStopWords(title);
        System.out.println("22222222");
        System.out.println(lists);*/

    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println("3333");

        WordFilter.automaticSelection("为什么晚上不能照镜子",a);
    }
}
