package liao.designpattern.tempalte;

import java.util.HashMap;
import java.util.Map;

public class LocalSetting extends AbstractSetting {

    Map<String,String> cache = new HashMap<>();

    @Override
    protected void putIntoCache(String key, String value) {
        cache.put(key,value);
    }

    @Override
    protected String lookupCache(String key) {
        return cache.get(key);
    }
}
