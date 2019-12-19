package src.com.bubble;

import java.util.Arrays;

/**
 * @program: suanfaProject
 * @description: 冒泡排序
 * @author: huwei
 * @create: 2019-12-19 16:15
 **/
public class BubbleOne {
    public static int[] sortKit(int[] array) {
        // 从小到大排序
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 优化第一版
     *
     * @param array
     * @return
     */
    public static int[] sortOptimization(int[] array) {
        // 从小到大排序
        for (int i = 0; i < array.length; i++) {
            // 加个标识, 判断是否已有序，就不循环了
            // 有序标记，每一轮的初始值都是true
            boolean sortFlag = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;

                    //因为有元素进行交换，所以不是有序的，标记变为false
                    sortFlag = false;
                }
            }
            if (sortFlag) {
                break;
            }
        }
        return array;
    }

    /**
     * 优化第二版(设置个无序边界，在往后就是有序区了)
     *
     * @param array
     * @return
     */
    public static int[] sortOptimizationTwo(int[] array) {
        // 记录最后一次交换的位置
        int lastExchangeIndex = 0;
        // 无序数列的边界，每次比较只需要比到这里为止
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            // 有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                int tmp = 0;
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    // 因为有参数交换， 不是无序的，标记为false
                    isSorted = false;

                    // 更新为最后一次交换元素的位置
                    lastExchangeIndex = j;

                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] array = new int[]{6, 5, 12, 3, 9, 84, 1};
        // array = sortOptimizationTwo(array);  // 845100
        // array = sortKit(array); // 279900
        // array = sortOptimization(array); // 254500
        System.out.println(Arrays.toString(array));
        long endTime = System.nanoTime();
        long xhtime = endTime - startTime;
        System.out.println(String.format("耗时时间 >>> %s",xhtime));
    }
}
