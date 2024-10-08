package com.tz.LeetCode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution_0118 {
    public static void main(String[] args) {
        SolutionR_0118 solutionR_0118 = new SolutionR_0118();
        List<List<Integer>> list = solutionR_0118.generate(3);
        Iterator<List<Integer>> iterator = list.iterator();
        while (iterator.hasNext()){
            List<Integer> next = iterator.next();
            System.out.println(next.toString());
        }

        System.out.println("--------------------------------------");
        List<List<Integer>> list1 = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            List<Integer> l1 = new LinkedList<>();
            for (int j = 0; j <= i; j++) {
                l1.add(1);
            }
            list1.add(l1);
        }
        Iterator<List<Integer>> iterator1 = list1.iterator();
        while (iterator1.hasNext()){
            List<Integer> next = iterator1.next();
            System.out.println(next.toString());
        }

        System.out.println("--------------------------------------");

        List<List<Integer>> list2 = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            List<Integer> l2 = new LinkedList<>();
            for (int j = 0; j < 10 - i; j ++) {
                l2.add(1);
            }
            list2.add(l2);
        }
        Iterator<List<Integer>> iterator2 = list2.iterator();
        while (iterator2.hasNext()){
            List<Integer> next = iterator2.next();
            System.out.println(next.toString());
        }

    }
}

class SolutionR_0118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i){
                    list.add(1);
                }else {
                    list.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                }
            }
            result.add(list);
        }
        return result;
    }
}