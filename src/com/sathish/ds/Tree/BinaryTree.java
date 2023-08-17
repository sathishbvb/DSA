package com.sathish.ds.Tree;


import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
         this.left = left;
        this.right = right;
    }
 }

public class BinaryTree {

    public TreeNode findMinNode(TreeNode root){
        int[] a;
        TreeNode curr = root;
        while(curr!=null && curr.left!=null){
            curr=curr.left;
        }
        return curr;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(root.val<key){
            root.right=deleteNode(root.right,key);
        }
        else if(root.val>key){
            root.left=deleteNode(root.left,key);
        }
        else{
            if (root.right==null){
                return root.left;
            }
            else if(root.left==null){
                return root.right;
            }
            else{
                TreeNode minNode = findMinNode(root);
                root.val= minNode.val;
                deleteNode(root,minNode.val);
            }
        }
        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val>val){
            root.left=insertIntoBST(root.left,val);
        }
        else if(root.val<val){
            root.right=insertIntoBST(root.right,val);
        }
        return root;
    }

    public List<Integer> inorderTraversal(TreeNode tree,ArrayList<Integer> list){
        if(tree==null){
            list.add(null);
            return null;
        }
        inorderTraversal(tree.left,list);
        list.add(tree.val);
        inorderTraversal(tree.right,list);
        return null;
    }


}
