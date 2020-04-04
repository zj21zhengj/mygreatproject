package com.tencent.mashibing.step030;


import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;

public class XxEntity_Helper {

    public <TEntity>TEntity create(Class<TEntity> entityClazz,ResultSet rs) throws Exception {
        if (null == rs) {
            return null;
        }
        //
        // 更通用的助手类,
        // 甭管实体类是哪个, 也甭管实体类有多少属性,
        // 全灭!
        // 但是,
        // 就是性能太差了...
        //
        // 创建新的实体对象
        Object obj = entityClazz.newInstance();
        //获取类的字段数组  私有方法必须是Declared，pubclic可以直接用fileds
        Field[] fArray = entityClazz.getDeclaredFields();
        System.out.println(fArray.length);
        for(Field f:fArray) {
            //获取字段上的注解
            Column annColumn = f.getAnnotation(Column.class);
            if(annColumn == null) {
                // 如果注解为空,
                // 则直接跳过...
                continue;
            }
            //获取列的名称
            String columnName = annColumn.name();
            System.out.println("xxx");
            System.out.println(columnName);
            //从数据库获取值
            Object value = rs.getObject(columnName);
            System.out.println(value);
            PropertyDescriptor pd = new PropertyDescriptor(f.getName(), entityClazz);
            Method wM = pd.getWriteMethod();//获得写方法
            wM.invoke(obj,value);
        }
        return (TEntity) obj;
    }
}
