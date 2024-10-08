package com.tz.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Solution_0003 {
    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(new SolutionR_0003().lengthOfLongestSubstring3(str));
    }
}
class SolutionR_0003 {
    //查询含有两个相同的字母的最长距离
    public int lengthOfLongestSubstring1(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if (chars[i] == chars[j]){
                    max = (max > j - i)? max : j -i;
                    break;
                }
            }
        }
        return max;
    }
    //不含有重复字符的最长子串的长度
    public int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        Set<Character> hashset;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            hashset = new HashSet();
            hashset.add(chars[i]);
            for (int j = i+1; j < s.length(); j++) {
                //存在相同的字符，计算相同的字符之间的长度
                if (hashset.contains(chars[j])){
                    max = (max > hashset.size())? max : hashset.size();
                    break;
                }
                hashset.add(chars[j]);
            }
            //不存在相同的字符，计算总长度
            max = (max > hashset.size())? max : hashset.size();
        }
        return max;
    }

    //不含有重复字符的最长子串的长度
    public int lengthOfLongestSubstring3(String s) {
        char[] chars = s.toCharArray();
        Set<Character> hashset = new HashSet<>();
        int max = 0;
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1;
        for (int i = 0; i < s.length(); i++) {
            if(i != 0){
                hashset.remove(chars[i-1]);
            }
            while (rk +1 < s.length() && !hashset.contains(chars[rk + 1])){
                hashset.add(chars[rk + 1]);
                rk++;
            }
            max = (max > rk - i + 1)? max : rk - i + 1;
        }
        return max;
    }


}