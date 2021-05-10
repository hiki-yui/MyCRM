package com.zs.hiki.utils;

import java.util.ArrayList;
import java.util.List;

public class PageUtils {
    public static List<Object> cutBase (List base,Integer page,Integer pageSize){
        List<Object> list = new ArrayList<>();//一页展示的数据量应该不会很多,不改初始值
        int arrivedIndex = page*pageSize;//目标点的下标
        int start = (page-1)*pageSize;//开始的下标
        for (;start<arrivedIndex;start++){
            //获取当页页展示的数据
            if (start==base.size()){
                break;//如果数据获取完了就截止
            }
            list.add(base.get(start));
        }
        return list;
    }
}
