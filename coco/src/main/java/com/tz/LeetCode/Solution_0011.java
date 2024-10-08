package com.tz.LeetCode;

public class Solution_0011 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height1 = {1,1};
        System.out.println(new SolutionR_0011().maxArea2(height));
    }
}
class SolutionR_0011 {
    //暴力法
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                int x = Math.min(height[i],height[j]);
                int area = x * (j - i);
                maxArea = (maxArea > area) ? maxArea :area;
            }
        }
        return maxArea;
    }
    //双指针
    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length -1;
        int maxArea = 0;
        while (left <= right){
            if(height[left] < height[right]){
                int x = Math.min(height[right],height[left]);
                int area = x * (right - left);
                maxArea = (maxArea > area) ? maxArea :area;
                left++;
            }else {
                int x = Math.min(height[right],height[left]);
                int area = x * (right - left);
                maxArea = (maxArea > area) ? maxArea :area;
                right--;
            }
        }
        return maxArea;
    }
}