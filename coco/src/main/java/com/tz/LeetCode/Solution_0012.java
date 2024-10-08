package com.tz.LeetCode;

public class Solution_0012 {
    public static void main(String[] args) {
        SolutionR_0012 solutionR_0012 = new SolutionR_0012();
        System.out.println(solutionR_0012.intToRoman3(98));
//        for (int i = 1; i <= 90; i += 1) {
//            System.out.println(solutionR_0012.intToRoman(i));
//        }
    }
}
class SolutionR_0012 {

    //暴力算法
    public String intToRoman(int num) {
        if(num < 0 || num > 4000){
            return "false";
        }
        StringBuilder stringBuilder = new StringBuilder();
        if(num >= 90 && num < 100){
            stringBuilder.append("XC");
            num -= 90;
        }
        if(num >= 50 && num < 90){
            stringBuilder.append("L");
            num -= 50;
        }
        if(num >= 40 && num < 50){
            stringBuilder.append("XL");
            num -= 40;
        }
        if(num < 40 && num >= 10){
            while (num >= 10){
                stringBuilder.append("X");
                num -= 10;
            }
        }
        if(num == 9){
            stringBuilder.append("IX");
            num =-9;
        }
        if(num >= 5 && num < 9){
            stringBuilder.append("V");
            num -= 5;
            while (num > 0){
                stringBuilder.append("I");
                num --;
            }
        }
        if(num >= 4 && num < 5){
            stringBuilder.append("IV");
            num =-4;
        }
        if(num < 4){
            while (num > 0){
                stringBuilder.append("I");
                num --;
            }
        }
        return stringBuilder.toString();
    }
    //使用两个数组存储相对应的符号和整数值
    public String intToRoman2(int num) {
        // 罗马数字的符号和对应的整数值
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        // 遍历每个整数值，尽可能地使用该值对应的罗马数字
        for (int i = 0; i < values.length && num >= 0; i++) {
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }

        return roman.toString();
    }
    //暴力法直接罗列出各位置对应的数（StringBuilder 的使用避免了频繁的字符串拼接操作，减少了内存分配和回收的负担）
    public String intToRoman3(int num) {
        // 罗马数字的符号和对应的整数值
        String[] M = {"", "M", "MM", "MMM"}; // 1000，2000，3000
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; // 100~900
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}; // 10~90
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}; // 1~9

//        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
        // 使用StringBuilder拼接字符串
        StringBuilder roman = new StringBuilder();
        roman.append(M[num / 1000]);
        roman.append(C[(num % 1000) / 100]);
        roman.append(X[(num % 100) / 10]);
        roman.append(I[num % 10]);

        return roman.toString();
    }


}
