package test;

/**
 * 总结  一般方法遇到异常就会终止，不会执行到最后的return 主函数接受到子函数抛出的异常也会抛出，终止执行
 * 但是finally 是总会执行的
 * 抛出异常后，可以捕获的
 */
public class TestThrow {
    public static void main(String[] args) throws Exception {
        int a = 0;
        /*try {
            a = getNumm(100);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("方法遇到错误后不会返回return");
        }*/
        a = getNums(200);
        System.out.println(a);
    }

    private static int getNums(int i) throws Exception{
        int h = i/0;
        System.out.println("这是结果");
        return h;
    }

    private static int getNumm(int i) throws Exception {
        int h = 0;
        try {
            h = i/0;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex);
        } finally {
            //return h;
        }
        return h;
    }
}
