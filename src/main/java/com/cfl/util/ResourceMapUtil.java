package com.cfl.util;

import org.apache.commons.collections.map.HashedMap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ResourceMapUtil {
    public static final Map<Integer,String> resourceMap = new HashedMap(){
        {
            put(0,"51job");
            put(1,"zhilian");
            put(2,"dajie");
            put(3,"haitou");
            put(4,"lagou");
            put(5,"shixiseng");
        }
    };

    public static Integer getKeyByValue(String value){
        for (Integer key : resourceMap.keySet()) {
            if(value.equals(resourceMap.get(key))){
                return key;
            }
        }
        return new Integer(-1);
    }
}
