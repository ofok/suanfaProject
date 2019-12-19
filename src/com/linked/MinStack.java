package com.linked;

import java.util.Stack;

/**
 * 利用栈求出最小值
 * 最小栈的实现
 */
public class MinStack {
    private Stack<Integer> mainStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    /**
     * 入栈操作
     *
     * @param element 入栈的元素
     */
    public void push(int element) {
        mainStack.push(element);
        // 如果辅助栈为空，或者新元素小于或等于辅助栈栈顶， 则将新元素压入辅助栈
        if (minStack.isEmpty() || element <= minStack.peek()) {
            minStack.push(element);
        }
    }

    /**
     * 出栈操作
     *
     * @return
     */
    public Integer pop() {
        // 如果出栈元素和辅助栈栈顶元素值相等，辅助栈出栈
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return mainStack.pop();
    }


    /**
     * 获取栈的最小元素
     * @return
     * @throws Exception
     */
    public int getMin() throws Exception {
        if (minStack.empty()) {
            throw new Exception("stack is empty");
        }
        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }
}
