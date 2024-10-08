package com.tz.LeetCode;

public class Solution_2319 {
    public static void main(String[] args) {
        int[][] grif = {{1,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}};
        System.out.println(new SolutionR_2319().checkXMatrix1_1(grif));
    }
}
class SolutionR_2319 {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //斜对角线
                if(i == j && grid[i][j]==0){
                    return false;
                }
                //反斜对角线
                else if (i == n - j - 1 && grid[i][j] == 0){
                    return  false;
                }else if (i != j && i != n - j - 1 &&grid[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkXMatrix1(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 检查对角线和反对角线位置，必须是非零
                if ((i == j || i == n - j - 1) && grid[i][j] == 0) {
                    return false;
                }
                // 非对角线位置必须为零
                if (i != j && i != n - j - 1 && grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkXMatrix1_1(int[][] grid){
        int n = grid.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j || (i + j) == (n - 1)) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else if (grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
