package com.dictionary;

import java.util.Arrays;

/**
 * 字典序算法
 * 怎么样寻找一个整数所有数字全排列的下一个数？
 * <p>
 * 获得全排列下一个数的3个步骤。
 * 1. 从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界。
 * 2. 让逆序区域的前一位和逆序区域中大于它的最小的数字交换位置。
 * 3. 把原来的逆序区域转为顺序状态 。
 * <p>
 * 例如 ： 12345 -> 12354 -> 12453 -> 12435
 */
public class DictionaryAlgorithm {
    public static int[] findNearestNumber(int[] numbers) {
        // 从后向前查看逆序区域，找到逆序区域的前一位，也见识数字置换边界
        int index = findTransferPoint(numbers);
        // 如果数字置换边界是0， 说明整个数组已经逆序，无法得到更大的相同数
        // 字组成的整数，返回null
        if (index == 0) {
            return null;
        }
        // 2.把逆序区域的前一位和逆序区域中刚刚大于它数字交换位置
        // 复制并入参，避免直接修改入参
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        exchangeHead(numbersCopy, index);
        // 3.把原来的逆序区域转为顺序
        reverse(numbersCopy, index);
        return numbersCopy;
    }

    private static int findTransferPoint(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] > numbers[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    private static int[] exchangeHead(int[] numbersCopy, int index) {
        int head = numbersCopy[index - 1];
        for (int i = numbersCopy.length - 1; i > 0; i--) {
            if (head < numbersCopy[i]) {
                numbersCopy[index - 1] = numbersCopy[i];
                numbersCopy[i] = head;
                break;
            }
        }
        return numbersCopy;
    }

    private static int[] reverse(int[] numbersCopy, int index) {
        for (int i = index, j = numbersCopy.length - 1; i < j; i++, j--) {
            int temp = numbersCopy[i];
            numbersCopy[i] = numbersCopy[j];
            numbersCopy[j] = temp;
        }
        return numbersCopy;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        // 打印12345 之后的10个全排列整数 (118个)
        for (int i = 0; i < 119; i++) {
            numbers = findNearestNumber(numbers);
            outputNumbers(numbers);
        }
    }

    // 输出数组
    private static void outputNumbers(int[] numbers) {
        for (int i : numbers) {
            System.out.print(i);
        }
        System.out.println();
    }

}
