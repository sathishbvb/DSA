package com.sathish.ds.Tree;

public class TreeDataStructure {

    public static class Node{
        int val;
        Node next;
        public Node(){

        }
        public Node(int val,Node next){
            this.val=val;
            this.next=next;
        }
    }
    public static void main(String[] args) {
        Node head;
        head = new Node(1,null);
        Node one = new Node(2,null);
        Node two = new Node(3,null);
        Node three = new Node(4,null);
        head.next=one;
        one.next=two;
        two.next=three;
        Node trav = head;

        while(trav!=null){
            System.out.println(trav.val);
            trav=trav.next;
        }

    }
}