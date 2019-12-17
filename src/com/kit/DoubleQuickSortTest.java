package com.kit;

import java.util.Arrays;

/**
 * 递归方法实现快速排序（双循环排序法）
 * @author  huwei
 * @date 2019-12-17 21:14
 */
public class DoubleQuickSortTest {
    public static void quickSort(int[] arr, int startIndex, int endIndex){
        // 递归结束条件 ： startIndex 大于或等于 endIndex时
        if(startIndex >= endIndex){
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        // 根据基准元素，分成两部分进行递归排序
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    /**
     * 分治（双边循环法）
     * @param arr  待交换的数组
     * @param startIndex  起始下标
     * @param endIndex  结束下标
     * @return
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置(也可以选择随机位置)的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right){
            // 控制right 指针比较并左移
            while(left < right && arr[right] > pivot){
                right -- ;
            }
            // 控制left 指针比较并右移
            while(left < right && arr[left] <= pivot){
                left ++;
            }
            // 交换left 和 right指针所指向的元素
            if(left < right){
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        // piovt 和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;

        return left;
    }

    public static void  main(String[] args){
        Long startTime = System.nanoTime();
        int arr[] = new int [] {4,7,6,5,3,2,8,1};
        quickSort(arr, 0, arr.length - 1);
        Long endTime = System.nanoTime();
        Long all = endTime - startTime;
        System.out.println(all);
        System.out.println(Arrays.toString(arr));
    }
}
