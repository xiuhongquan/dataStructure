package com.xiu.linkedList;

import java.util.Stack;

/**
 * 栈的基本使用
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        stack.add("tom");
        stack.add("jerry");
        stack.add("john");
        while (stack.size()>0){
            //从栈中取出数据(出栈)
            System.out.println(stack.pop());
        }
    }
}
