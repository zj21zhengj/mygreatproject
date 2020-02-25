package com.unclear;

import java.nio.charset.Charset;

public class Unclear {
    public static void main(String[] args) {
        System.out.println(new StringBuilder().append("Byte-->").append("字节数").append(Byte.BYTES)
                .append(";位数").append(";最小值-->最大值").append(Byte.MIN_VALUE).append("-->").append(Byte.MAX_VALUE));

        System.out.println(new StringBuilder().append("Short-->").append("字节数").append(Short.BYTES)
                .append(";位数").append(";最小值-->最大值").append(Short.MIN_VALUE).append("-->").append(Short.MAX_VALUE));

        System.out.println(new StringBuilder().append("Integer-->").append("字节数").append(Integer.BYTES)
                .append(";位数").append(";最小值-->最大值").append(Integer.MIN_VALUE).append("-->").append(Integer.MAX_VALUE));

        System.out.println(new StringBuilder().append("Long-->").append("字节数").append(Long.BYTES)
                .append(";位数").append(";最小值-->最大值").append(Long.MIN_VALUE).append("-->").append(Long.MAX_VALUE));

        System.out.println(new StringBuilder().append("Float-->").append("字节数").append(Float.BYTES)
                .append(";位数").append(";最小值-->最大值").append(Float.MIN_VALUE).append("-->").append(Float.MAX_VALUE));

        System.out.println(new StringBuilder().append("Double-->").append("字节数").append(Double.BYTES)
                .append(";位数").append(";最小值-->最大值").append(Double.MIN_VALUE).append("-->").append(Double.MAX_VALUE));

        System.out.println (new StringBuilder ().append ("Character-->>").append ("字节数：").append (Character.BYTES).append (";位数：").
                append (Character.SIZE).append ("; 最小值-->最大值:").append ((int)Character.MIN_VALUE).append ("-->").append ((int)Character.MAX_VALUE));

        short b = 32763;
        System.out.println(b);
        double c = Math.pow(2,-32);
        System.out.println(c);


        //###################################################################################

        System.out.println(Charset.defaultCharset());//获取ide默认编码类型
        String s = new String("13801927805".getBytes());
        byte[] bs = s.getBytes();
        System.out.println(Long.BYTES);
        System.out.println("" + bs.length);
        System.out.println("结论是电话号码时用long代替string 更省内存");
        /**
         * System.out.println(Charset.defaultCharset());//获取ide默认编码类型
         * String s = new String(“中国”.getBytes());
         * byte[] b = s.getBytes();
         * System.out.println("" + b.length);
         * ————————————————
         * 版权声明：本文为CSDN博主「B-thousand」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
         * 原文链接：https://blog.csdn.net/weixin_44517990/article/details/99491841
         */
        /**
        2.String s = “中国”; 占多少字节？
        System.out.println(Charset.defaultCharset());//获取ide默认编码类型
        String s = new String(“中国”.getBytes());
        byte[] b = s.getBytes();
        System.out.println("" + b.length);
        //UTF-8 编码时，每一个汉字占用 3 个字节，那么中国占用 6 个字节

         3.UTF-8 转 GBK 编码格式
         System.out.println(Charset.defaultCharset());
         String s;
         try {
         s = new String(“中国”.getBytes(),“GBK”);
         byte[] b = s.getBytes();
         System.out.println(s );
         System.out.println(b.length);
         } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
         }
         如上代码是：UTF-8 转 GBK 编码格式，s 长度从 6 字节变为 9 字节。
         ————————————————
         版权声明：本文为CSDN博主「B-thousand」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
         原文链接：https://blog.csdn.net/weixin_44517990/article/details/99491841。
         **/
    }
}
