package com.example.demo.sort;

/**
 * 希尔排序
 */
//排序原理 https://m.runoob.com/data-structures/shell-sort.html
public class ShellSort {
    //时间复杂度O(n*n) 空间复杂度 O(1)
    //核心代码---开始
    public static void sort(Comparable[] arr) {
        int j;
        for (int gap = arr.length / 2; gap >  0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                Comparable tmp = arr[i];
                for (j = i; j >= gap && tmp.compareTo(arr[j - gap]) < 0; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = tmp;
            }
        }
    }
    //核心代码---结束
    public static void main(String[] args) {

        int N = 2000;
        Integer[] arr = new  Integer[]{1,3,6,2,5,7,8,9,10,50,4};
        ShellSort.sort(arr);
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
    }
}
