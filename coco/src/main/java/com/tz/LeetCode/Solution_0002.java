package com.tz.LeetCode;

import com.tz.util.ListNode;

public class Solution_0002 {
    public static void main(String[] args) {
        ListNode<Integer> listNode = new ListNode(2);
        listNode.setNext(new ListNode(4));
        listNode.getNext().setNext( new ListNode(3));

        ListNode<Integer> listNode2 = new ListNode(5);
        listNode2.setNext(new ListNode(6));
        listNode2.getNext().setNext( new ListNode(4));
        ListNode<Integer> result =  new SolutionR2_0002().addTwoNumbers(listNode,listNode2);
        while (result != null){
            System.out.print(result.getVal()+"-->");
            result = result.getNext();
        }
    }
}

class SolutionR_0002 {
    public ListNode addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        // 哨兵节点，便于处理结果链表的头节点
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0; // 用于保存进位
        // 遍历两个链表，直到两个链表都为null
        while(l1 != null || l2 != null){
            // 获取两个链表当前节点的值，如果链表已经遍历完，则视为0
            int x = (l1 != null)? l1.val : 0;
            int y = (l2 != null)? l2.val : 0;
            //计算当前位的总和和进位
            int sum = x + y + carry;
            carry = sum/10;
            current.next =  new ListNode(sum % 10);
            current = current.next;
            //移动到下一个节点
            if(l1!= null) l1 = l1.next;
            if(l2!= null) l2 = l2.next;
        }
        if(carry > 0){
            current.next =  new ListNode(carry);
        }
        return dummy.next;
    }
}

class SolutionR2_0002 {
    public ListNode addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode dummy = new ListNode(0);
        ListNode current  = dummy;
        int carry = 0;//用于保存进位
        while (l1!=null||l2!=null){
            int x =(l1!=null)?l1.val:0;
            int y =(l2!=null)?l2.val:0;
            int sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(carry>0){
            current.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
