package com.tencent.mashibing.step020;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectEntity_Helper {

    public SubjectEntity create(ResultSet rs) throws Exception {
        if (null == rs) {
            return null;
        }
        //
        // 有了反射,
        // 这下就不怕实体类的修改了...
        // 实体类你随便改!
        // 我们还能再优化一步, 将这个 UserEntity_Handler 改的更通用!
        // 跳到 XxxEntity_Helper 类看看!
        //
        // 创建新的实体对象
        SubjectEntity ue = new SubjectEntity();
        Class clazz = SubjectEntity.class;
        Object obj = clazz.newInstance();
        //获取类的字段数组  私有方法必须是Declared，pubclic可以直接用fileds
        Field[] fArray = clazz.getDeclaredFields();
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
            PropertyDescriptor pd = new PropertyDescriptor(f.getName(), clazz);
            Method wM = pd.getWriteMethod();//获得写方法
            wM.invoke(obj,value);
        }
        return (SubjectEntity) obj;
    }
}
