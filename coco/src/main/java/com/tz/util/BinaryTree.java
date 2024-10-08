package com.tz.util;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
    public TreeNode<T> createBinaryTree(T[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        // 根节点
        TreeNode<T> root = new TreeNode<>(values[0]);
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < values.length) {
            // 取出队列中的节点
            TreeNode<T> current = queue.poll();

            // 左子节点
            if (values[i] != null) {
                current.left = new TreeNode<>(values[i]);
                queue.offer(current.left);
            }
            i++;

            // 右子节点
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode<>(values[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // 测试：按层次遍历输出二叉树
    public void levelOrderTraversal(TreeNode<T> root) {
        if (root == null) return;

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }


    // 打印二叉树结构
    public static <T> void printTree(TreeNode<T> root) {
        if (root == null) return;

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size(); // 当前层的节点数量
            StringBuilder nodeLevel = new StringBuilder();  // 用于存储当前层的节点
            StringBuilder branchLevel = new StringBuilder(); // 用于存储当前层的分支

            boolean hasNonNull = false; // 检查是否还有非空节点，避免死循环

            // 遍历当前层的所有节点
            for (int i = 0; i < size; i++) {
                TreeNode<T> current = queue.poll();

                // 打印节点值
                if (current != null) {
                    nodeLevel.append(current.val).append(" ");
                    queue.add(current.left);
                    queue.add(current.right);

                    // 打印分支符号
                    if (current.left != null) {
                        branchLevel.append("/ ");
                        hasNonNull = true;
                    } else {
                        branchLevel.append("  "); // 左子为空，留空格
                    }

                    if (current.right != null) {
                        branchLevel.append("\\ ");
                        hasNonNull = true;
                    } else {
                        branchLevel.append("  "); // 右子为空，留空格
                    }
                } else {
                    // 当前节点为空时，加入空位占用符
                    nodeLevel.append("  ");
                    branchLevel.append("    ");  // 两个空位
                }
            }

            // 输出节点值层和分支层
            System.out.println(nodeLevel.toString());
            if (!branchLevel.toString().trim().isEmpty()) {  // 有分支才打印
                System.out.println(branchLevel.toString());
            }

            // 如果当前层没有非空节点，终止循环，避免死循环
            if (!hasNonNull) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>();
        Integer[] values = {3, 9, 20, null, null, 15, 7};
        TreeNode<Integer> root = bt.createBinaryTree(values);

        // 输出层次遍历的结果
        bt.printTree(root);  // 输出：3 9 20 15 7
    }
}
