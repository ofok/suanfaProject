package com.kit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 快速排序
 * 非递归方法实现 (单边循环法)
 * @author huwei
 * @date 2019-12-17 21:09
 */
public class QuickSortTest {
    public static void quickSort(int[] arr, int startIndex, int endIndex){
        // 用一个集合栈代替递归的函数栈
        Stack<Map<String, Integer>> quickSortStack = new Stack<>();
        // 整个数列的起止下标，以哈希的形式入栈
        Map rootParam = new HashMap();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        quickSortStack.push(rootParam);

        // 循环结束条件：栈为空的时候
        while(!quickSortStack.isEmpty()){
            // 栈顶元素出栈，得到起止下标
            Map<String, Integer> param = quickSortStack.pop();
            // 得到基准元素起始位置
            int pivotIndex = partition(arr, param.get("startIndex"), param.get("endIndex"));
            // 根据基准元素分成两部分，把每一部分的起止下标入栈
            if(param.get("startIndex") < pivotIndex - 1){
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex - 1);
                quickSortStack.push(leftParam);
            }

            if(pivotIndex + 1 < param.get("endIndex")) {
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }
    }

    /**
     * 分治（单边循环法）
     * @param arr  待交换的数组
     * @param startIndex  起始下标
     * @param endIndex  结束下标
     * @return
     */
    private static int partition(int[] arr, Integer startIndex, Integer endIndex) {
        // 取第一个位置（也可以随机位置）的元素作为基准元素
        int pivot = arr[startIndex];
        int mark = startIndex;
        for(int i = startIndex + 1; i<= endIndex; i++){
            if(arr[i] < pivot){
                mark ++ ;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
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
