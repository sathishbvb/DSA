package com.sathish.ds.timecomp;

public class EpisodeOne {

    public static void main(String[] args) {
        simpleLoop(5,2);
        //System.out.println(sumOfNNumbers(5));
    }
    public static int sumOfNNumbers(int n){

        return (n*(n+1))/2;
    }

    public static void simpleLoop(int n,int c){
        for(int i = 1 ;i<n;i=i/c){
            System.out.println(i);
        }
    }
}
