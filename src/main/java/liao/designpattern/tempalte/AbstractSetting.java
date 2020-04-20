package liao.designpattern.tempalte;

public abstract class AbstractSetting {
    public final String getSetting(String key) {
        String value = lookupCache(key);
        if (value == null) {
            value = readFromDatabase(key);
            putIntoCache(key, value);
        }
        return value;
    }

    protected abstract void putIntoCache(String key, String value);

    protected abstract String lookupCache(String key);

    private String readFromDatabase(String key) {
        return Integer.toHexString(0x7fffffff & key.hashCode());
    }
}


