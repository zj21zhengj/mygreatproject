package ioooc.wukong.immoc.computable;

import java.io.IOException;

public class MayFail implements Computable<String,Integer> {
    @Override
    public Integer computer(String arg) throws Exception {
        if(Math.random() > 0.5)
            throw new IOException("读取文件错误");
        Thread.sleep(3000);
        return new Integer(arg);
    }
}
