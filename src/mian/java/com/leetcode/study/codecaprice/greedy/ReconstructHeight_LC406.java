package com.leetcode.study.codecaprice.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : Cody.Teng
 * @date : 2023-08-09 6:38 p.m.
 */
public class ReconstructHeight_LC406 {

    public static void main(String[] args) {
        int[][] ints = reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});

    }
    public static int[][] reconstructQueue(int[][] people) {

        if (people.length == 1) {
            return people;
        }
        Arrays.sort(people, (a, b) -> {
            if (a[0]==b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });

        List<int[]> queue = new LinkedList<>();
        for (int[] person : people) {
            System.out.println(person[1]);
            System.out.println(Arrays.toString(person));
            queue.add(person[1], person);
        }

        return queue.toArray(new int[people.length][]);
    }
}
