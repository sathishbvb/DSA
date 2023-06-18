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
        Node root1 = new Node(107);
        Node root2 = new Node(108);
        leftChild.setLeftChild(root1);
        leftChild.getLeftChild().setLeftChild(root2);
        //preOrderTraversal(root);
       // inorderTraversal(root);
        //System.out.println(heightOfATree(root));
        //inorderTraversalRecursion(root);
        printNodeAwayFromKNode(root,3);

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
        nodeStack.push(root.getRightChild());
        nodeStack.push(root.getLeftChild());
        while (!nodeStack.isEmpty()) {
            Node n = nodeStack.pop();
            if (n.getRightChild() != null) {
                nodeStack.push(n.getRightChild());
            }
            System.out.println(n.getKey());
            if (n.getLeftChild() != null) {
                nodeStack.push(n.getLeftChild());
            }
        }
}

    public static void inorderTraversalRecursion(Node root){
        if(root!=null){
            inorderTraversalRecursion(root.getLeftChild());
            System.out.println(root.getKey());
            inorderTraversalRecursion(root.getRightChild());
        }
    }

    public static int heightOfATree(Node root){
        if(root==null){
            return 0;
        }
            return(Math.max(heightOfATree(root.getLeftChild()),heightOfATree(root.getRightChild()))+1);
    }

    public static void printNodeAwayFromKNode(Node root,int k){
        if(root==null){
            return;
        }
       if(k==0){
           System.out.println(root.getKey());
       }
       else{
           printNodeAwayFromKNode(root.getLeftChild(),k-1);
           printNodeAwayFromKNode(root.getRightChild(),k-1);
       }
    }



}
