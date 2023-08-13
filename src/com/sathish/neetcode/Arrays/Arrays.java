package com.sathish.neetcode.Arrays;

import java.util.*;

public class Arrays {
    public static void main(String[] args) {
        Arrays arr = new Arrays();
        int[] ints = {1, 1};
//        System.out.println(arr.containsDuplicate(ints));
//        System.out.println(java.util.Arrays.toString(arr.getConcatenation(ints)));
//        System.out.println(java.util.Arrays.toString(arr.replaceElements(new int[]{18,17,4,5,6,1})));
//        System.out.println(arr.twoSum(new int[]{2,7,11,15},9));
//        System.out.println(arr.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
//        System.out.println(java.util.Arrays.toString(arr.topKFrequent(new int[]{1,2},2)));
//        System.out.println(java.util.Arrays.toString(arr.productExceptSelf(new int[]{1,2,3,4})));
//        System.out.println(arr.encode1(new ArrayList<>(List.of(new String[]{"sathish", ":", "lint", "code"}))));
//        System.out.println(arr.decode1(arr.encode1(new ArrayList<>(List.of(new String[]{"sathish", ":", "lint", "code"})))));
        System.out.println(arr.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    //Two Approach
    //1)For Each i value we can iterate j to find duplicates but o(N^2)
    //2)Convert array into ser now time : o(n) & space o(n)
    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 0) {
            return false;
        }
        Set<Integer> set = new HashSet();
        for (int i : nums) {
            set.add(i);
        }

        return nums.length == set.size();
    }

    public boolean isAnagram(String s, String t) {
        char[] arr = s.toCharArray();
        char[] arr1 = t.toCharArray();
        java.util.Arrays.sort(arr);
        java.util.Arrays.sort(arr1);
        if (arr.length != arr1.length) {
            return false;
        }
        String s1 = new String(arr);
        String t1 = new String(arr1);
        if (s1.equals(t1)) {
            return true;
        }
        return false;
    }

    public int[] getConcatenation(int[] nums) {
        int size = nums.length * 2;
        int[] nums2 = new int[size];
        int i = 0, j = size / 2;

        for (int v : nums) {
            nums2[i] = v;
            nums2[j] = v;
            i++;
            j++;
        }
        return nums2;
    }

    public int[] replaceElements(int[] arr) {
        int max, i, n = arr.length;
        max = -1;
        for (i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(temp, max);
        }
        return arr;
    }

    public int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans.add((Integer) map.get(target - nums[i]));
                ans.add(i);
            }
            map.put(nums[i], i);
        }
        return ans.stream().mapToInt(j -> j).toArray();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return null;
        }
        for (String s : strs) {
            char[] c = s.toCharArray();
            java.util.Arrays.sort(c);
            map.putIfAbsent(new String(c), new ArrayList<>());
            map.get(new String(c)).add(s);
        }
        for (String str : map.keySet()) {
            ans.add(map.get(str));
        }
        return ans;
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i : nums) {
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i) + 1);
        }
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>(nums.length);
        int j = 0;
        while (j < nums.length) {
            ls.add(new ArrayList<>());
            j++;
        }
        for (Integer i : map.keySet()) {
            ls.get(map.get(i)).add(i);
        }
        int count = 0;
        for (int i = ls.size() - 1; i >= 0; i--) {
            if (count > k) {
                break;
            }
            if (ls.get(i).isEmpty()) {
                continue;
            }
            for (Integer in : ls.get(i)) {
                if (count > k) {
                    break;
                }
                ans.add(in);
                count++;
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[nums.length - 1] = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            ans[i - 1] = ans[i] * nums[i];
        }
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            temp = temp * nums[i - 1];
            ans[i] = ans[i] * temp;
        }
        return ans;
    }

    String encode(List<String> strs) {
        String encodedValue = "";
        for (String s : strs) {
            encodedValue = encodedValue + s + ":;";
        }
        return encodedValue;
    }

    String encode1(List<String> strs) {
        StringBuilder encodedValue = new StringBuilder();
        for (String s : strs) {
            encodedValue.append(s.length()).append("#").append(s);
        }
        return encodedValue.toString();
    }

    ArrayList<String> decode(String str) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack1 = new Stack<>();
        String ansStr = "";
        ArrayList<String> ans = new ArrayList<>();
        for (char i : str.toCharArray()) {
            if (i != ';') {
                stack.push(i);
            } else {
                if (stack.peek() == ':') {
                    stack.pop();
                    while (!stack.isEmpty()) {
                        stack1.push(stack.pop());
                    }
                    while (!stack1.isEmpty()) {
                        ansStr += stack1.pop();
                    }
                    ans.add(ansStr);
                    ansStr = "";
                }
            }
        }
        return ans;
    }

    ArrayList<String> decode1(String str1) {
        ArrayList<String> ans = new ArrayList<>();
        char[] str = str1.toCharArray();
        int j = 0;
        for (int i = 0; i < str.length; ) {
            j = i;
            while (str[j] != '#') {
                j += 1;
            }
            StringBuilder s = new StringBuilder();
            Integer len;
            for (int k = i; k < j; k++) {
                s.append(str[k]);
            }
            len = Integer.valueOf(s.toString());
            s = new StringBuilder();
            for (int f = j + 1; f < j + 1 + len; f++) {
                s.append(str[f]);
            }
            ans.add(s.toString());
            i = (j + 1) + len;
        }
        return ans;
    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for (int i : nums) {
            set.add(i);
        }
        int temp;
        for (Integer i : set) {
            temp = 1;
            for (int j = 0; j < nums.length; j++) {
                if(set.contains(i-1)){
                    break;
                }
                if (set.contains((i + 1 + j))){
                    temp += 1;
                } else {
                    break;
                }
            }
            max = Math.max(max, temp);
        }

        return max;
    }


}
