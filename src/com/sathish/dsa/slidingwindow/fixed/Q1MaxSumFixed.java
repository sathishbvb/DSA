package com.sathish.dsa.slidingwindow.fixed;

public class Q1MaxSumFixed {


    //arr= [2,3,4,5,1,2]
    //k=2

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,5,1,2};
        System.out.println(getMaximumSumWithinWindow(arr,6));
    }

    public static int getMaximumSumWithinWindow(int[] arr, int k){
        int l =0;
        int sum = 0,ans=0;
        for(int r=0;r<arr.length;r++){
            sum=sum+arr[r];
            if((r-l)+1 > k ){
                //means our window is of the given size
                sum=sum-arr[l];
                l+=1;
            }
            else if((r-l)+1 == k){
                ans = Math.max(ans,sum);
            }
        }
        return ans;
    }



}
