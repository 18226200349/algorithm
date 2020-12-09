package com.example.demo.sort;

import java.util.Random;

public class InsertSort {
    public static void main(String[] args) {
        int[] sortArr=new int[]{3,6,5,7,4};
//       e
        //0位置的数据作为已排序空间数据
        for (int i = 1; i <sortArr.length ; i++) {
            //第二个值，未排序空间第一个值，每循环一次往后拿一个值
             int value=sortArr[i];
             //j代表的是已排序空间的数据长度
             int j=i-1;
             //从已排序空间的第一个值进行比较
             for (;j>=0;j--){
               if(sortArr[j]>value){
                   //如果当前已排序空间的值大于未排序空间值，将小于当前未排序空间的值赋予它
                   sortArr[j+1]=sortArr[j];
               }else{
                   break;
               }
             }
             //将值赋予最后一个交换的位置
             sortArr[j+1]=value;
        }
    }
}
