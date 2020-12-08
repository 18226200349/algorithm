package com.example.demo.sort;

import java.util.Random;
public class BubbleSort {

    public static void main(String[] args) {
        int[] sortArr=new int[100000];
        for (int i = 0; i < sortArr.length; i++) {
            int x=100;
            Random random = new Random();
            int s= random.nextInt(100000);
            sortArr[i]=s;
        }
//        for (int i : sortArr) {
//            System.out.print(i+"  ");
//        }
      //冒泡排序
        Long startTime=System.currentTimeMillis();
        for (int i=0;i<sortArr.length;i++){
            //每次比较会将更大值放到更后面，减少一次两值之间的比较
            //当没有值进行交换时，说明整个
            boolean flag=true;
            for (int j = 0; j < sortArr.length - 1-i; j++) {
                if(sortArr[j]>sortArr[j+1]){
                    //交换位置
                    int temp=sortArr[j+1];
                    sortArr[j+1]=sortArr[j];
                    sortArr[j]=temp;
                    flag=false;
                }
            }
            //每次内循环判断是否有数据交换，若有，说明还存在未排序完成的数据，继续下一次循环，若无，说明已经有序
            if(flag){
                break;
            }
        }
        Long endTime=System.currentTimeMillis();
        System.out.println(" ");
        System.out.println("冒泡执行时间="+(endTime-startTime));
        System.out.print("结果");
//        for (int i : sortArr) {
//            System.out.print(i+"  ");
//        }
    }
}
