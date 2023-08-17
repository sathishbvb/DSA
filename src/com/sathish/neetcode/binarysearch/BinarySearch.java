package com.sathish.neetcode.binarysearch;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.search(new int[]{-1,0,3,5,9,12},5));
        System.out.println(bs.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},111));
    }
    public int search(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while(i<=j){
            int mid=(j+i+1)/2;
            if(nums[mid]>target){
                j=mid-1;
            }
            else if (nums[mid]<target) {
                i=mid+1;


            }if (nums[mid]==target) {
                return mid;
            }
        }
        return -1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int mid_val = matrix[mid / n][mid % n];

            if (mid_val == target)
                return true;
            else if (mid_val < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
}
