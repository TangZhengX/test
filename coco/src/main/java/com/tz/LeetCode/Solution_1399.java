package com.tz.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Solution_1399 {
    public static void main(String[] args) {
        System.out.println(new SolutionR_1399().countLargestGroup(15));
    }
    
}
class SolutionR_1399 {
    public int countLargestGroup(int n) {
        int max = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int x = i;int key = 0;
            while (x != 0){
                key = key +x%10;
                x=x/10;
            }
            hashMap.put(key,hashMap.getOrDefault(key,0) + 1);
            max = Math.max(hashMap.get(key),max);
        }
        int count = 0;
        for (Map.Entry<Integer,Integer> entry:hashMap.entrySet()){
            if (entry.getValue() == max){
                count ++;
            }
        }
        return count;
    }
}
