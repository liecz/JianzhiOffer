package com.solutions;

import java.util.Stack;

/**
 * Created by liec on 17-2-8.
 */
public class Solution_TwoStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.empty()) {
            return stack2.pop();
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution_TwoStack s = new Solution_TwoStack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
