package com.leetcode.study.codecaprice.array.prefixsum;

/**
 * @author : Cody.Teng
 * @date : 2023-07-14 2:33 p.m.
 */
public class NumMatrix_LC304 {

    private int[][] prefixSum;

    public NumMatrix_LC304(int[][] matrixNum) {

        if (matrixNum == null) {
            return;
        }

        int n = matrixNum.length;
        int m = matrixNum[0].length;

        if (n == 1 && m == 1) {
            return;
        }

        prefixSum = new int[n + 1][m + 1];

        for (int i = 1; i < matrixNum.length; i++) {
            for (int j = 1; j < matrixNum[0].length; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] + matrixNum[i - 1][j - 1] - prefixSum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int x1, int y1, int x2, int y2) {
        return prefixSum[x2 + 1][y2 + 1] - prefixSum[x1][y2 + 1] - prefixSum[x2 + 1][y1] + prefixSum[x1][y1];
    }
    
}
