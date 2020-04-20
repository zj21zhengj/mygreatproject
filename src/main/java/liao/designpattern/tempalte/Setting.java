package liao.designpattern.tempalte;

/**
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1281319636041762#0
 *
 * 模板方法  又称template方法

public class Setting {

    public final String getSetting(String key) {
        //先从缓存读取
        String value = looupCache(key);
        if(value == null) {
            value = readFromDatabase(key);
            System.out.println("[DEBUG] load from db: " + key + " = " + value);
            //放入缓存
            putIntoCache(key, value);
        } else {
            System.out.println("[DEBUG] load from cache: " + key + " = " + value);
        }
        return value;
    }

    private String readFromDatabase(String key) {
        // TODO: 从数据库读取
        return null;
    }


}
 */