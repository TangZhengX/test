package com.tz.LeetCode;

import java.util.HashMap;

public class Solution_0005 {
    public static void main(String[] args) {
        String s = "acaaccab";
        System.out.println(new SolutionR_0005().longestPalindrome3_1(s));
    }
}

class SolutionR_0005 {
    //以第一个字母开始到第一个字母结束 中间可以重复 2024年9月23日11:18:20
    public String longestPalindrome(String s) {
        int max = 0;
        int begin = 0;
        int end = 1;
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> hashMap = new HashMap();
        for (int i = 0; i < chars.length; i++) {
            if(hashMap.containsKey(chars[i])){
                if(i - hashMap.get(chars[i]) > max){
                    begin = hashMap.get(chars[i]);
                    end = i + 1;
                    max = begin - i;
                }
            }else {
                hashMap.put(chars[i],i);
            }
        }
        return s.substring(begin,end);
    }
    // 最长回文子串(动态规划)
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i   < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public String longestPalindrome2_2(String s) {
        int begin = 0;
        int maxlen = 1;
        int len = s.length();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        //初始化dp，长度为1的都为true
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        //L为最大长度,从2开始，1已经被初始化了
        for (int L = 2;L <= len; L++){
            //i开始的位置 左边界
            for (int i = 0; i < len; i++) {
                //j为右边界  j - i + 1 = L
                int j = L + i - 1;
                if(j >= len){
                    break;
                }
                //3以内，左边界和右边界相同，则视为true
                if(chars[i] != chars [j]){
                    dp[i][j] = false;
                }else {
                    if(j - i < 3){
                       dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxlen) {
                    maxlen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,maxlen+begin);
    }

    //中心扩展算法
    public String longestPalindrome3_1(String s) {
        char[] chars = s.toCharArray();
        int bagin = 0;
        int end = 1;
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            //中心扩展，两种情况，1.奇数，i为正中心的情况 2偶数，i为第一个数的情况
            int len1 = expandAroundCenter(chars,i,i);
            int leng1 = len1 * 2 + 1;
            if(leng1 > max){
                bagin = i - len1;
                end = i + len1 + 1;
                max = len1 * 2 + 1;
            }
            int len2 = expandAroundCenter(chars,i,i+1);
            int leng2 = len2 * 2 + 2;
            if(leng2 > max){
                bagin = i - len2;
                end = i + len2 + 2;
                max = len2 * 2 + 2;
            }
        }
        return s.substring(bagin,end);
    }

    public int expandAroundCenter(char[] chars, int left, int right) {
        int result = 0;
        while (left >= 0 && right < chars.length && chars[left] == chars[right]){
            left--;
            right++;
            result++;
        }
        return result - 1;
    }

}
