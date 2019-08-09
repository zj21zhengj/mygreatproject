package com.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public class NumberUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(NumberUtil.class);

    public static String NumberToCN(String num) {
        try {
            String fraction[] = {"角", "分"};
            String digit[] = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
            String unit1[] = {"", "拾", "佰", "仟"};//把钱数分成段,每四个一段,实际上得到的是一个二维数组
            String unit2[] = {"元", "万", "亿", "万亿"}; //把钱数分成段,每四个一段,实际上得到的是一个二维数组
            BigDecimal bigDecimal = new BigDecimal(num);
            bigDecimal = bigDecimal.multiply(new BigDecimal(100));
            String strVal = String.valueOf(bigDecimal.toBigInteger());
            if ("0".equals(strVal)) {
                return "零";
            }
            String head = "";         //整数部分
            String end = "";              //小数部分
            if (strVal.length() - 2 < 0) {
                String endMoney = "";
                end = strVal;
                if (strVal.length() == 1) {
                    endMoney += digit[Integer.valueOf(end)] + "分";
                } else if (strVal.length() == 2) {
                    endMoney += digit[Integer.valueOf(end.substring(0, 1))] + "角";
                    if (!end.substring(1, 2).equals("0")) {
                        endMoney += digit[Integer.valueOf(end.substring(1, 2))] + "分";
                    }
                }
                return endMoney;
            } else {
                head = strVal.substring(0, strVal.length() - 2);
                end = strVal.substring(strVal.length() - 2);
            }
            String endMoney = "";
            String headMoney = "";
            if ("00".equals(end)) {
                endMoney = "整";
            } else {
                if (!end.substring(0, 1).equals("0")) {
                    endMoney += digit[Integer.valueOf(end.substring(0, 1))] + "角";
                } else if (end.substring(0, 1).equals("0") && !end.substring(1, 2).equals("0")) {
                    endMoney += "零";
                }
                if (!end.substring(1, 2).equals("0")) {
                    endMoney += digit[Integer.valueOf(end.substring(1, 2))] + "分";
                }
            }
            char[] chars = head.toCharArray();
            Map<String, Boolean> map = new HashMap<String, Boolean>();//段位置是否已出现zero
            boolean zeroKeepFlag = false;//0连续出现标志
            int vidxtemp = 0;
            for (int i = 0; i < chars.length; i++) {
                int idx = (chars.length - 1 - i) % 4;//段内位置  unit1
                int vidx = (chars.length - 1 - i) / 4;//段位置 unit2
                String s = digit[Integer.valueOf(String.valueOf(chars[i]))];
                if (!"零".equals(s)) {
                    headMoney += s + unit1[idx] + unit2[vidx];
                    zeroKeepFlag = false;
                } else if (i == chars.length - 1 || map.get("zero" + vidx) != null) {
                    headMoney += "";
                } else {
                    headMoney += s;
                    zeroKeepFlag = true;
                    map.put("zero" + vidx, true);//该段位已经出现0；
                }
                if (vidxtemp != vidx || i == chars.length - 1) {
                    headMoney = headMoney.replaceAll(unit2[vidx], "");
                    headMoney += unit2[vidx];
                }
                if (zeroKeepFlag && (chars.length - 1 - i) % 4 == 0) {
                    headMoney = headMoney.replaceAll("零", "");
                }
            }
            return headMoney + endMoney;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getRandomCode() {
        StringBuffer buffer = new StringBuffer();
        Random random = new Random(/*System.currentTimeMillis()*/);
        for (int i = 0; i < 10; i++) {
            if (i < 7) {
                buffer.append((char) (random.nextInt(26) + 65));
            } else {
                buffer.append(random.nextInt(10));
            }
        }
        return buffer.toString();
    }

    /**
     * @param s
     * @return
     * @Title: rvZeroAndDot
     * @Description: 去掉小数点后面无效的0
     */
    public static String rvZeroAndDot(String s) {
        if (s.isEmpty()) {
            return null;
        }
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }

    public static String num2String(Long num) {
        String ret;
        if (num == null) {
            return "0.00";
        }
        String no = String.valueOf(Math.abs(num));
        if (no.length() == 1) {
            ret = "0.0" + no;
        } else if (no.length() == 2) {
            ret = "0." + no;
        } else if (no.length() > 2) {
            String no1 = no.substring(0, no.length() - 2);
            String no2 = no.substring(no.length() - 2, no.length());
            ret = no1 + "." + no2;
        } else {
            ret = "0.00";
        }
        if (num < 0) {
            return "-" + ret;
        }
        return ret;
    }

    public static String num4String(Long num) {
        if (num == null) {
            return "0.0000";
        }
        String no = num.toString();
        String flag = "";
        if ("-".equals(num.toString().substring(0, 1))) {
            flag = "-";
            no = num.toString().substring(1, no.length());
        }
        ;

        if (no.length() == 1) {
            return flag + "0.000" + no;
        } else if (no.length() == 2) {
            return flag + "0.00" + no;
        } else if (no.length() == 3) {
            return flag + "0.0" + no;
        } else if (no.length() == 4) {
            return flag + "0." + no;
        } else if (no.length() > 4) {
            String no1 = no.substring(0, no.length() - 4);
            String no2 = no.substring(no.length() - 4, no.length());
            return flag + no1 + "." + no2;
        } else {
            return "0.0000";
        }
    }

    public static Boolean numisAcoumt(String num) {
        if (num == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("^(([1-9]\\d*)|\\d)(\\.\\d{1,2})?$");
        boolean matches = pattern.matcher(num).matches();
        return matches;
    }

    /**
     * 四舍五入取整
     *
     * @param amount
     * @param rate
     * @return
     */
    public static long getRateFee(long amount, String rate) {
        String tmpAmount = String.valueOf(amount);
        return new BigDecimal(tmpAmount).multiply(new BigDecimal(rate)).setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
    }
}
