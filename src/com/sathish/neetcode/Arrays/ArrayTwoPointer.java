package com.sathish.neetcode.Arrays;

import java.util.*;
import java.util.Arrays;

public class ArrayTwoPointer {
    public static void main(String[] args) {
        ArrayTwoPointer a = new ArrayTwoPointer();
        //System.out.println(a.isPalindrome("ab_a"));
        //System.out.println(java.util.Arrays.toString(a.twoSum(new int[]{2,7,11,15},9)));
        //a.threeSum(new int[]{-1,0,1,2,-1,-4},0);
//        System.out.println(a.maxArea(new int[]{1,0,0,0,0,0,0,2,2}));
//        System.out.println(a.trapRainWater(new int[]{4,2,3}));
        System.out.println(a.maxProfit(new int[]{7,1,5,3,6,4}));
    }
    public boolean isPalindrome1(String s) {
        int i = 0, j = s.length() - 1;
        if (s.equals(" ")) {
            return Boolean.TRUE;
        }
        char[] c = s.toCharArray();
        while (i < j) {
            while (i < j && ('a' - Character.toLowerCase(c[i])) > 25 && Character.isDigit(c[i])) {
                i++;
            }
            while (j > i && ('a' - Character.toLowerCase(c[j])) > 25&& Character.isDigit(c[j])) {
                j--;
            }
            if ((Character.toLowerCase(c[i])) == (Character.toLowerCase(c[j]))) {
                if(i>=j){continue;}
                i++;
                j--;
                continue;
            }
            if ((Character.toLowerCase(c[i])) != (Character.toLowerCase(c[j]))) {
                return Boolean.FALSE;
            }

        }
        return Boolean.TRUE;
    }
    public static boolean isAlphaNumeric(String s) {
        return s != null && s.matches("^[a-zA-Z0-9]*$");
    }
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            Character st = s.charAt(i);
            Character end = s.charAt(j);
            if (!Character.isLetterOrDigit(st)) {
                i++;
            }
            if (!Character.isLetterOrDigit(end)) {
                j--;
            }
            if (Character.toLowerCase(st) != Character.toLowerCase(end)) {
                return Boolean.TRUE;
            }
            i++;
            j--;
        }
        return Boolean.TRUE;
    }
    public int[] twoSum(int[] numbers, int target) {
        int i =0,j=numbers.length-1;
        while (i<j){
            if(numbers[i]+numbers[j]>target){
                j--;
            }
            else if(numbers[i]+numbers[j]<target){
                i++;
            }
            else{
                break;
            }
        }
        return new int[]{i+1,j+1};
    }
    public ArrayList<Integer> twoSum(int[] numbers, int target,int start) {
        int i =start,j=numbers.length-1;
        while (i<j){
            if(numbers[i]+numbers[j]>target){
                j--;
            }
            else if(numbers[i]+numbers[j]<target){
                i++;
            }
            else{
                break;
            }
        }
        return new ArrayList<Integer>(Arrays.asList(numbers[i+1],numbers[j+1]));
    }
    public List<List<Integer>> threeSum(int[] numbers,int integer){
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        Set<Integer> tmp = new HashSet<>();
        Arrays.sort(numbers);
        ArrayList<Integer> val = null;
        for(int i =0;i<numbers.length-1;i++){
            if(!tmp.add(numbers[i])){continue;}
            val=twoSum(numbers,(-numbers[i]),i+1);
            if(!val.isEmpty()) {
                val.add(0, numbers[i]);
                System.out.println();
                ans.add(val);
            }
        }
        System.out.println(ans);
        return ans;
    }

    public int maxArea(int[] height) {
        if(height.length==0){
            return 0;
        }
        int i = 0,j=height.length-1,max=-1;
        while(i<j){
            max=Math.max(max,Math.min(height[i],height[j])*(j-i));
            if(i<j && height[i]<height[j]){
                i++;
                continue;
            }
            if(i<j&&height[i]>height[j]){
                j--;
                continue;
            }
            if(height[i]==height[j]){
                j--;
                continue;
            }
        }
        return max;
    }

    public int trapRainWater1(int[] arr){
        int i=0,j=i+2;
        int ans = 0;
        int sum=0;
        while(j<arr.length){
            sum =0 ;
           while(arr[j]<=arr[i]){
               if(arr[i]==0 && arr[j]==0){
                   i++;
                   j++;
                   break;
               }
               if(j+1>=arr.length){i++;break;}
               j++;

           }
           if(Math.min(arr[i],arr[j])*(j-i-1)>0){
               int temp1=i+1,temp2=j;
               while(temp1<temp2){
                   sum+=arr[temp1];
                   temp1++;
               }
               if((Math.min(arr[i],arr[j])*(j-i-1)-sum)>0){
                   ans+=(Math.min(arr[i],arr[j])*(j-i-1)-sum);
                   i=j;
                   j=i+2;
                   continue;
               }
           }
           i++;
           j++;
        }
        return ans;

    }

    public int trapRainWater(int[] height){
        if (height.length == 0) return 0;
        int i=0;
        int j=height.length-1;
        int lMax=height[i];
        int rMax=height[j];
        int ans=0;
        while(i<j){
            if(lMax<rMax){
                i++;
                lMax=Math.max(lMax,height[i]);
                ans += lMax - height[i];
            }
            else{
                j--;
                rMax = Math.max(rMax,height[j]);
                ans+= rMax-height[j];
            }
        }
        return ans;
    }

    public int maxProfit(int[] prices) {
        int i=0,j=i+1,max=0;
        while(j< prices.length){
            if(prices[j]<prices[i]){
                i=j;
                j=j+1;
            }
            else if(prices[j]-prices[i]<0){
                i++;
                j++;
            }
            else if(prices[j]-prices[i]>=0){
                max=Math.max(max,(prices[j]-prices[i]));
                j++;
            }
        }
        return max;
    }
}
