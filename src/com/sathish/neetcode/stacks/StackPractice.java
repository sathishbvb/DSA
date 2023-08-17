package com.sathish.neetcode.stacks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Stack;

public class StackPractice {

    public static void main(String[] args) {
        StackPractice sp = new StackPractice();
        System.out.println(sp.calPoints(new String[]{"5","2","C","D","+"}));
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println( minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top()); // return 0
        System.out.println( minStack.getMin()); // return -2
    }

    public int calPoints(String[] operations) {
        if(operations.length<0){
            return 0;
        }
        Stack<Integer> s = new Stack<>();
        int ans=0;
        for(String str : operations){
            if(str.equals("C")){
                s.pop();
            } else if (str.equals("D")) {
                s.push(s.peek()*2);
            } else if (str.equals("+")) {
                int temp=s.pop();
                int val = s.peek()+temp;
                s.push(temp);
                s.push(val);
            }
            else{
                s.push(Integer.parseInt(str));
            }
        }
        return ans;
    }
}

class MinStack {
    Stack<Integer> stack;
    int minVal;


    public MinStack() {
        this.stack=new Stack<>();
        this.minVal=Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(val<=minVal){
            stack.push(minVal);
            minVal=val;
        }
        stack.push(val);
    }

    public void pop() {
        if(stack.pop()==minVal)
            minVal=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minVal;
    }
}

