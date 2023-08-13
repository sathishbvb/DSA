package com.sathish.neetcode.Arrays;

public class Sorting {
    public static void main(String[] args) {
        Sorting sor = new Sorting();
        //System.out.println(java.util.Arrays.toString(sor.insertionSort(new int[]{2,3,4,1,6})));
        System.out.println(java.util.Arrays.toString(sor.bucketSort(new int[]{2,2,1,0,0,2})));

    }
    public int[] insertionSort(int[] arr){
        for(int i =1;i< arr.length;i++){
            int j = i-1;
            while(j>=0 && arr[j+1]<arr[j]){
                int temp;
                temp = arr[j+1];
                arr[j+1]=arr[j];
                arr[j]=temp;
                j--;
            }
        }
        return arr;
    }
    public int[] bucketSort(int[] arr){
        int[] count = new int[arr.length];
        for(int v : arr){
            count[v]+=1;
        }
        int i =0;
        int idx=0;
        while(i<count.length){
            int j =0;
            while(j<count[i]){
                arr[idx]=i;
                j++;
                idx++;
            }
            i++;
        }
        return arr;
    }
}
