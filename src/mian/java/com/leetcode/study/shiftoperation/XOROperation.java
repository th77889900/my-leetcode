package com.leetcode.study.shiftoperation;

import com.sun.nio.sctp.SctpStandardSocketOptions;

/**
 * 异或运算
 *
 * @author ：tigger
 * @date ：Created in 2022/5/7 3:32 下午
 */
public class XOROperation {

    /**
     * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [4,1,4,6]
     * 输出：[1,6] 或 [6,1]
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,10,4,1,4,3,3]
     * 输出：[2,10] 或 [10,2]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void oddNumbers(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        // 获取eor最左边
        int rightOne = eor & (~eor + 1);
        int theOne = 0;
        for (int value : arr) {
            if ((value & rightOne) == 0) {
                theOne ^= value;
            }
        }
        System.out.println(theOne + " " + (eor ^ theOne));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 4, 6};
        oddNumbers(arr);
    }
}
