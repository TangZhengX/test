package com.tz.util;

public class ListNode<T> {
    public T val;
    public ListNode next;
    public ListNode() {}
    public ListNode(T val) { this.val = val; }
    public ListNode(T val, ListNode next) { this.val = val; this.next = next; }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}