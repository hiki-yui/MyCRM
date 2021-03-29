package com.zs.hiki.utils;

import java.lang.reflect.Field;
import java.util.*;

public class JsonUtils {
    /**
     * 将一个对象转化为一个,没有,变量名,的JSON格式的字符串
     * 可以转化为JSON嵌套
     * @param o 任意类型对象
     * @return JSON格式的字符串
     */
    public static String getJson(Object o)  {
        //字符串拼接
        StringBuilder builder=new StringBuilder(80);
        //判断是否是一个空字符串,若不是开始获取该类中的属性值
        if (o!=null){
            builder.append("{");
            //反射机制,获取该类的Class对象
            Class oClass=o.getClass();
            //获取该类中所有的属性对象
            Field[] oFields=oClass.getDeclaredFields();
            //一次获取属性值
            for(Field f:oFields){
                try {
                    //打破封装
                    f.setAccessible(true);
                    Class fType=f.getType();
                    //判断,如果属性是基本数据类型及其封装类,直接进行赋值的字符串拼接操作
                    if(fType==Boolean.class||fType.isPrimitive()||fType.getSuperclass()==java.lang.Number.class){
                        builder.append("\""+f.getName()+"\":"+f.get(o)+",");
                    }else if(fType==String.class){
                        //如果是String类型,直接拼接,带双引号
                        builder.append("\""+f.getName()+"\":\""+f.get(o)+"\",");
                    }else{
                        //若是引用数据类型,则再次调用该方法,获取该引用类型内相关的属性值
                        //方法重载,会多删一次逗号,所以要补上一个逗号//将返回的结果集进行拼接
                        builder.append(",\""+f.getName()+"\":"+getJson(f.get(o)));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            //删除多余的逗号
            builder.deleteCharAt(builder.lastIndexOf(","));
            //完成拼接
            builder.append("}");
            return builder.toString();
        }
        return builder.toString();
    }

    /**
     * 将一个对象转化为一个有变量名的JSON格式字符串
     * @param name JSON的名字
     * @param o 任意类型对象
     * @return JSON格式的字符串
     */
    public static String getJson(String name,Object o){
        //该方法就多了一个给予JSON变量名的操作
        StringBuilder builder=new StringBuilder(80);
        builder.append("var "+name+"=");
        builder.append(getJson(o));
        return builder.toString();
    }

    /**
     * 返还一个var name=一个装有众多json对象的字符串
     * @param name json对象的名字
     * @param l 集合
     * @return json
     */

    public static String getJson(String name,Collection l){
        StringBuilder builder=new StringBuilder(80);
        builder.append("var "+name+"=");
        builder.append("[");
        //获取迭代器
        //遍历集合
        for (Object o : l) {
            if (o instanceof Map) {       //如果对象为map
                Map map = (Map) o;
                builder.append(getJson(map) + ",");
            } else if (o != null) {      //如果元素不为null,则获取该元素中对应的属性值
                builder.append(getJson(o));
                builder.append(",");
            }
        }
        builder.append("]");
        //删除多余逗号
        builder.deleteCharAt(builder.lastIndexOf(","));
        return builder.toString();
    }

    /**
     * 接上无var xx=
     * @param l 集合
     * @return json
     */
    public static String getJson(Collection l){
        String json=getJson("",l);
        return json.substring(json.indexOf("=")+1);
    }

    /**
     * 要求:key是String类型
     * 返还一个完整的JSON字符串,key是
     * @param name JSON对象的变量名
     * @param map  key代表JSON中的变量名,value代表变量名的值
     * @return JSON格式的字符串
     */
    public static String getJson(String name,Map map){
        StringBuilder builder=new StringBuilder(80);
        builder.append("var "+name+"={");
        Set<Map.Entry> s =map.entrySet();
        for (Map.Entry entry : s) {
            Object o = entry.getValue();
            if (o != null) {
                Class oClass = o.getClass();
                if (oClass == Boolean.class || oClass.isPrimitive() || oClass.getSuperclass() == Number.class) {
                    builder.append("\"" + entry.getKey() + "\":" + o + ",");
                } else if (oClass == String.class) {
                    builder.append("\"" + entry.getKey() + "\":\"" + o + "\",");
                } else {
                    builder.append("\"" + entry.getKey() + "\":" + getJson(o) + ",");
                }
            } else {
                builder.append("\""+entry.getKey()+"\":null,");
            }
        }
        builder.deleteCharAt(builder.lastIndexOf(","));
        builder.append("}");
        return builder.toString();
    }

    /**
     * 接上,无var xx=
     * @param map HashMap
     * @return json
     */
    public static String getJson(Map map){
        String json=getJson("",map);
        return json.substring(json.indexOf("=")+1);
    }

    /**
     * 返还一个JSON中给属性赋值的字符串
     * @param name JSON对象中属性的变量名
     * @param values 值
     * @return JSON格式的字符串
     */
    public static String getJson(String name,String[] values){
        StringBuilder builder=new StringBuilder(80);
        builder.append("\""+name+"\":"+"[");
        for (String value : values) {
            builder.append("\"" + value + "\",");
        }
        builder.deleteCharAt(builder.lastIndexOf(","));
        builder.append("]");
        return builder.toString();
    }

}
