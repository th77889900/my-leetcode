package com.leetcode.study.sort;

import java.util.Arrays;

/**
 * 插入排序实现
 *
 * @author ：tenghu
 * @date ：Created in 2022/5/7 4:54 下午
 */
public class InsertionSort {

    public static int[] insertSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; j--) {
                swap(array, j, j + 1);
            }
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {7, 6, 6, 6, 5, 4, 3, 2, 1};
        int[] ints = insertSort(array);
        System.out.println(Arrays.toString(ints));
    }
}
