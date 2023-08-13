package com.sathish.ds.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Arrays2 {
    public static void main(String[] args) {
        //rotateArrayLeft();
        //rotateArrayByDElem();
        //leaderInArray();
        //maximumDifference();
        freqOfNumbers();
    }
    public static void rotateArrayLeft(){
        int[] noArray = {1,2,3,4,5,6};
        int firstEle = noArray[0];
        for(int i = 0;i<noArray.length-1;i++){
            int temp = noArray[i];
            noArray[i]=noArray[i+1];
            noArray[i+1]=temp;
        }
        noArray[noArray.length-1]=firstEle;
        System.out.println(java.util.Arrays.toString(noArray));
    }

    public static void rotateArrayByDElem(){
        int d = 1,i=0;
        int[] arr ={1,2,3,4,5,6};
        while(d<arr.length){
            int t=d;
            while(t>i){
                int temp = arr[t];
                arr[t]=arr[t-1];
                arr[t-1]=temp;
                t--;
            }
            d++;
            i++;
        }
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void leaderInArray(){
        int[] noArr = {1, 2, 3, 4, 5, 2};
        int max = noArr[noArr.length-1];
        for(int i = noArr.length-2;i>=0;i--){
            if(noArr[i]>max){
                System.out.println(max);
                max=noArr[i];
            }
        }
        System.out.println(max);
    }

    public static void maximumDifference(){
        int[] noArr = {30,20,10};
        int max = Integer.MIN_VALUE;
//        for(int i =0;i< noArr.length;i++){
//            for(int j=i+1;j<noArr.length;j++){
//                if(noArr[j]-noArr[i]>max){
//                    max=noArr[j]-noArr[i];
//                }
//            }
//        } o(N^2)
        Arrays.stream(noArr).sorted();
        max=noArr[0]-noArr[noArr.length-1];
        System.out.println(max);
    }

    public static void freqOfNumbers(){
        int[] noArr = {11,11,22,22,33,44,44};
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i:noArr){
            if(!hashMap.containsKey(i)){
                hashMap.put(i,1);
            }
            else{
                hashMap.put(i, (hashMap.get(i)+1));
            }
        }
        Set<Integer> s = new HashSet<>();
        s=hashMap.keySet();
        for (Integer j : s){
            System.out.println(j+" : "+hashMap.get(j));
        }

    }
}
