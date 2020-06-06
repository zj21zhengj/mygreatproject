package weichat;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public final class WxUtil {

    private static final String TOKEN = "334AiAlKrs";

    //校验
    public static boolean check(String timestamp,String nonce,String signature) {

        String[] strs = new String[]{TOKEN,timestamp,nonce};
        Arrays.sort(strs);

        String str = strs[0]+strs[1]+strs[2];
        String mysig = sha1(str);
        return signature.equalsIgnoreCase(mysig);
    }

    /**
     * 进行sha1加密
     */
    private static String sha1(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("sha1");
            //加密
            byte[] digest = md.digest(str.getBytes());
            char[] chars = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
            StringBuilder sb = new StringBuilder();
            //处理加密结果
            for(byte b:digest) {
                sb.append(chars[(b>>4)&15]);
                sb.append(chars[b&15]);
            }
            System.out.println(sb.toString());
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
