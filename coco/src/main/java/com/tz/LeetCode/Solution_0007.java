package com.tz.LeetCode;

public class Solution_0007 {
    public static void main(String[] args) {
        System.out.println(new SolutionR_0007().reverse(-120));
    }
}
class SolutionR_0007 {
    public int reverse(int x) {
        //三种情况1.负数 2.能够被10整除 3.不能被10整除
        int result = 0;
        boolean i = x > 0;
        x = i? x : -x;
        while (x != 0){
            result = result*10 + x % 10;
            x = x / 10;
        }
        return i? result : -result;
    }

    public int reverse2(int x) {
        int res = 0;
        while(x!=0) {
            //每次取末尾数字
            int tmp = x%10;
            //判断是否 大于 最大32位整数
            if (res>214748364 || (res==214748364 && tmp>7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res<-214748364 || (res==-214748364 && tmp<-8)) {
                return 0;
            }
            res = res*10 + tmp;
            x /= 10;
        }
        return res;
    }
}
