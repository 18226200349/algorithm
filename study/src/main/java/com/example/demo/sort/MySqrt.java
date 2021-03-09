package com.example.demo.sort;

//二分法获取一个数的平方根，精确到某一个位置
public class MySqrt {
    //precision精确度
//a原数据
  static  double squareRoot(double a , double precision){
        double low,high,mid,tmp;
        if (a>1){
            low = 1;
            high = a;
        } else {
            low = a;
            high = 1;
        }
        //退出条件
        while (low<=high) {
            mid = (low+high)/2.000;
            tmp = mid*mid;
            //退出结果条件
            if (tmp-a <= precision && tmp-a >= precision*-1){
                return mid;
            }
            //范围缩小条件
            else if (tmp>a){
                high = mid;
            }else{
                low = mid;
            }
        }
        return -1.000;
    }

    public static void main(String[] args) {
        double num = squareRoot(2, 0.000001);
        System.out.printf("%f",num);
    }

}
