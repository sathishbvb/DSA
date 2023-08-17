package com.sathish.ds;

public class Solution {
    public static void main(String[] args) {
        nForest(5);
    }
    public static void nForest(int n) {
        String s = "";
        int j =0;
        while(j<n){
            s=s+"*";
            j++;
        }
        for(int i = 0 ; i<n ; i++){
            System.out.println(s);
        }
    }
}
