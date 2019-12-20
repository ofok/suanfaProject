package com.divisor;

/**
 *
 */
public class TwoPower {

    // 求是否是2的整数次幂
    // 很简单，对于一个整数n，只需要计算n&(n-1)的结果是
    // 不是0。这个方法的时间复杂度只有O（1）。

    public static boolean isPowerOf2(int num) {
        return (num & num - 1) == 0;
    }

    public static void main(String[] args) {
        boolean flag = isPowerOf2(16);
        System.out.println(flag);
    }
}
