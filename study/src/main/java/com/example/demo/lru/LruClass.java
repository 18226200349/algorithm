package com.example.demo.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 利用LinkedHashMap简单手写LRU算法
 */
public class LruClass {
    public static void main(String[] args) {
        final int maxSize=10;
        //false 按照插入顺序排序 ，true 按照访问顺序排序
        Map<Integer,Integer> map=new LinkedHashMap<Integer,Integer>(0,0.75f,true){
            // LinkedHashMap加入新元素时会自动调用该方法，若返回true，则会删除链表尾部的元素
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size()>maxSize;
            }
        };
        for (int i = 1; i <=10 ; i++) {
            map.put(i,i);
        }
        map.get(6);
        System.out.println("发现第6个排到了链表头部："+map.toString());
        map.put(11,11);
        System.out.println("删除链表尾部的元素，再将新的元素添加至链表头部 ："+map.toString());
    }
}
