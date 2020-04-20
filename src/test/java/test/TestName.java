package test;

import java.io.File;

public class TestName {
    public static void main(String[] args) {
        // TODO 自动生成方法存根
        File f = new File("D:\\BaiduNetdiskDownload\\new.txt");
        String c = f.getParent();
        File mm = new File("D:\\BaiduNetdiskDownload\\new2.txt");
        System.out.println(mm.getName());
        if (f.renameTo(mm)) {
            System.out.println("修改成功!");
        } else {
            System.out.println("修改失败");
        }
    }
}
