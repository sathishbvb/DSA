package com.sathish.ds.misc;

import com.sathish.ds.StackList;

class Node<T>{
    T val;
    Node next;
    public Node(){
        this.next=null;
    }
    public Node(T val , Node next){
        this.val = val;
        this.next = next;
    }
}
public class LinkedList {
    public static void main(String[] args) {
        Node<Integer> start = new Node();
        Node<String> node1 = new Node();
        node1.val="Sathish";
        Node<Boolean> node2 = new Node();
        node2.val = false;
        start.val = 1;
        start.next=node1;
        node1.next=node2;
        Node temp = start;

        while(temp!=null){
            System.out.println(temp.val);
            temp=temp.next;
        }
        StackList<Integer> stackList = new StackList();
        System.out.println(stackList.isEmpty());
        stackList.push(1);
        stackList.push(1);
        stackList.push(1);
        System.out.println(stackList.isEmpty());
        System.out.println(stackList.size());
        System.out.println(stackList.peek());
        System.out.println(stackList.pop());
        System.out.println(stackList.pop());
        System.out.println(stackList.isEmpty());
    }

}
