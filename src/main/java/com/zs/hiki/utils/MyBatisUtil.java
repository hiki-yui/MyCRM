package com.zs.hiki.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*不提供重名覆盖解决方法
* 如果引用类型对象中有另一个引用类型属性,那么这两个引用类型的所有属性名需要不同
* 否则会发生覆盖*/
public class MyBatisUtil {
    public static Map<String,Object> beMap(Object obj){
        Map<String,Object> map = new HashMap<>();//一个对象的属性数量应该不会超过20,就不设置容量了
        //获取对象的class类
        Class oClass = obj.getClass();
        Field[] fields = oClass.getDeclaredFields();//获取对象属性
        eachAndPut(map,fields,obj);//遍历对象属性并放到map中
        //获取对象名称
        String name = oClass.getSimpleName();
        map.put("objectName",name);//放入名称//利用先放入的key会被后放入的key覆盖
        //达成objectName永远是顶级对象
        return map;
    }
    private static void eachAndPut(Map<String,Object> map,Field[] fields,Object obj){
        for ( Field field:fields) {
            Class fieldType=field.getType();
            field.setAccessible(true);//打破封装
            //如果该属性是是基本数据类型,是基本数据类型的包装类,字符串类型数据的话直接封装入map中
            if (fieldType==Boolean.class||fieldType.isPrimitive()||fieldType.getSuperclass()==java.lang.Number.class||fieldType==String.class){
                try {
                    Object value=field.get(obj);
                    map.put(field.getName(),value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }else{//如果是自定义的对象
                try {
                    Object value = field.get(obj);
                    if (value!=null){
                        Map<String,Object> otherMap=beMap(value);//再次调用beMap方法将自定义对象变成map
                        Set<Map.Entry<String,Object>> keyValues= otherMap.entrySet();
                        for (Map.Entry<String,Object> keyValue:keyValues) {//获取另一个map中的所有值,拼接到父Map
                            map.put(keyValue.getKey(),keyValue.getValue());
                        }
                    }else{
                        map.put(field.getName(),null);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
