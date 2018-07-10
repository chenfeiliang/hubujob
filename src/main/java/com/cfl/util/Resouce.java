package com.cfl.util;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

public enum Resouce {

    _51JOB("51job", 1), ZHILIAN("zhilian", 2), DAJIE("dajie", 3),
    HIATOU("haitou", 4), LAGOU("lagou", 5), SHIXIZENG("shixiseng", 6);


/*    public static final Map<Integer,String> resourceMap = new HashedMap(){
        {
            for (Resouce resouceEnum : Resouce.values()) {
                resourceMap.put(resouceEnum.index, resouceEnum.name);
            }

        }
    };*/

    private String name ;

    private int index ;

    private Resouce(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}
