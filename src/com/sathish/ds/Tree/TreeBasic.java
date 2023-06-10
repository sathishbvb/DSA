package com.sathish.ds.Tree;

import java.util.Stack;

public class TreeBasic {
    static class Node{
        int key;
        Node leftChild;
        Node rightChild;

        public Node(int key){
            this.key=key;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        Node leftChild = new Node(20);
        Node rightChild = new Node(30);
        root.setLeftChild(leftChild);
        root.setRightChild(rightChild);
        //preOrderTraversal(root);
        inorderTraversal(root);
    }

    public static void preOrderTraversal(Node root) {
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root.getRightChild());
        nodeStack.push(root.getLeftChild());
        System.out.println(root.getKey());
        while (!nodeStack.isEmpty()) {
            Node n = nodeStack.pop();
            System.out.println(n.getKey());
            if (n.getRightChild() != null)
                nodeStack.push(n.getRightChild());
            else {
                if (n.getLeftChild() != null)
                    nodeStack.push(n.getLeftChild());
            }
        }
    }

    public static void inorderTraversal(Node root){
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);
        nodeStack.push(root.getLeftChild());
        while (!nodeStack.isEmpty()) {
            Node n = nodeStack.pop();
                if (n.getLeftChild() != null)
                    nodeStack.push(n.getLeftChild());
                else{
                    System.out.println(n.getKey());
                    if(n.getRightChild()!=null){
                        nodeStack.push(n.getRightChild());
                    }
                }
            }
    }

    public void testfunction(){

    }

}
