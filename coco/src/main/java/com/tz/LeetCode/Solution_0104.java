package com.tz.LeetCode;

import com.tz.util.BinaryTree;
import com.tz.util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 */
public class Solution_0104 {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        Integer[] values = {3, 9, 20, null, null, 15, 7};
        TreeNode<Integer> root = binaryTree.createBinaryTree(values);
//        binaryTree.printTree(root);
        SolutionR_0104 solutionR_0104 = new SolutionR_0104();
        System.out.println(solutionR_0104.maxDepth1(root));
    }
}

class SolutionR_0104 {
    //层次遍历
    public int maxDepth(TreeNode<Integer> root) {
        int max = 0;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            // 取出队列中的节点
            TreeNode<Integer> current = queue.poll();
            if(current.left != null){
                queue.offer(current.left);
            }
            if(current.right != null){
                queue.offer(current.right);
            }
        }
        return max;
    }
    //方法一：深度优先搜索  最大深度等于左子树的最大深度 或者是右子树的最大深度 +1
    public int maxDepth1(TreeNode<Integer> root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth1(root.left);
        int right = maxDepth1(root.right);
        return Math.max(left,right) + 1;
    }
}
