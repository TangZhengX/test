package com.tz.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution_3282 {
    public static void main(String[] args) {
        Integer[] nums = {1,3,1,5};
        Integer[] nums1 = {4,3,1,3,2};
        System.out.println(Arrays.asList(nums).getClass());
        ArrayList<Integer> arrayList = new ArrayList(Arrays.asList(nums));
        System.out.println(arrayList.toString());
        System.out.println(new SolutionR_3282().findMaximumScore1(arrayList));
    }
}
class SolutionR_3282 {
    public long findMaximumScore(List<Integer> nums) {
        int left = 0;
        int right = 1;
        long max = 0l;
        while (right <nums.size()){
            if(nums.get(right) > nums.get(left)){
                max = max + (right - left)*nums.get(left);
                left = right;
            }
            right++;
        }
        max = max + (nums.size() - left -1)*nums.get(left);
        return max;
    }

    public long findMaximumScore1(List<Integer> nums) {
        long ans = 0;
        int max = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            max = Math.max(max, nums.get(i));
            ans = ans + max;
        }
        return ans;
    }
}
