package com.example.demo.sort;

public class SelectSort {

    public static void main(String[] args) {
        int[] sortArr=new int[]{3,6,5,7,4};
        for(int i=0;i<sortArr.length;i++){
            //设置第一个值默认为已排序空间
            int min=i;
            //然后在未排序空间找到值最小的下标
            for(int j=i;j<sortArr.length;j++){
                if(sortArr[j] < sortArr[min]) min=j;
            }
            //如果当前值不是最小值进行交换
            if(min != i){
                int temp=sortArr[i];
                sortArr[i]=sortArr[min];
                sortArr[min]=temp;
            }
        }
    }
}