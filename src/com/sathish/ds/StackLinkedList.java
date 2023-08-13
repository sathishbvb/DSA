package com.sathish.ds;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

class Node<T>{
    T val;
    Node next;
    public Node(){
        this.next=null;
    }
    public Node(T val ,Node next){
        this.val = val;
        this.next = next;
    }
}
public class StackLinkedList<V> {
    Node lastNode;
    public StackLinkedList(){
        this.lastNode=null;
    }
    public void push(V value){
        Node<V> node = new Node<>();
        node.val=value;
        node.next=this.lastNode;
        this.lastNode=node;

    }
    public V pop(){
        return (V) lastNode.val;
    }

    public static void main(String[] args) {
        StackLinkedList<Integer> stackLinkedList = new StackLinkedList<>();
        stackLinkedList.push(10);
        stackLinkedList.push(11);
        stackLinkedList.push(12);
        System.out.println(isValid("{[()]}"));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack= new Stack<>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('|| c=='{' ||c=='['){
                stack.push(c);
                continue;
            }
            if(stack.isEmpty()){
                return false;
            }
            char cmp;
            switch(c) {
                case ')':
                    cmp = stack.pop();
                    if(cmp=='{' || cmp == '[')
                        return false;
                    break;
                case '}':
                    cmp = stack.pop();
                    if(cmp=='[' || cmp == '(')
                        return false;
                    break;
                case ']':
                    cmp = stack.pop();
                    if(cmp=='{' || cmp == '(')
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}
