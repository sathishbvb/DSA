package com.sathish;

import com.sun.jdi.CharType;

import java.util.*;


public class Misc {

    public static void main(String[] args) {
        Misc m= new Misc();
        //m.containsDuplicate(new int[]{1,2,3,1});
//        System.out.println(m.isAnagram("anagram", "nagaram"));
//        System.out.println(Arrays.toString(m.bubbleSort(new int[]{0,-4,1,-1})));
//        System.out.println(m.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
//        System.out.println(Arrays.toString(m.topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
//        System.out.println(Arrays.toString(m.productExceptSelf(new int[]{-1,1,0,-3,3})));
//        System.out.println(m.encode(new ArrayList<>(List.of(new String[]{"lint","code","love","you"}))));
//        System.out.println(m.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

    public boolean containsDuplicate(int[] nums) {
        if(nums.length==0 || nums.length==1){
            return true;
        }
        HashSet<Integer> set = new HashSet();
        for(int i : nums){
            if(!set.add(i)){
                return true;
            }
        }
        return false;
    }

    public boolean isAnagram1(String s, String t) {
        char[] s1= s.toCharArray();
        char[] t1= t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1,t1);
    }

    public boolean isAnagram2(String s, String t) {
        HashMap<Character,Integer> map1 =new HashMap<>();
        HashMap<Character,Integer> map2 =new HashMap<>();
        for (char i : s.toCharArray()){
            map1.put(i,map1.getOrDefault(i,0)+1);
        }
        for (char i : t.toCharArray()){
            map2.put(i,map2.getOrDefault(i,0)+1);
        }
        for(Character i :map1.keySet()) {
            if (!map2.containsKey(i) && !(map2.get(i).equals(map1.get(i)))) {
                return false;
            }
        }
        return true;
    }
    public boolean isAnagram(String s, String t) {

        int[] ints = new int[26];
        for (char i : s.toCharArray()){
            int a =i-97;
            ints[a] = ints[a]+1;
        }
        for (char i : t.toCharArray()){
            int a =i-97;
            ints[a] = ints[a]-1;
        }
        for(int i :ints) {
            if(i!=0){
                return false;
            }
        }
        return true;
    }

    public int[] bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            if(i<target && map.containsKey((target-nums[i]))){
                return new int[]{i, map.get(target-nums[i])};
            }
            else if(i<target){
                map.put(nums[i],i);
            }
        }
        return null;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new            HashMap();
            for(String str : strs){
                char[] c = new char[26];
                for(char ch : str.toCharArray()){
                    c[(ch-97)]+=1;
                }
            map.putIfAbsent(Arrays.toString(c),new ArrayList<String>());
            map.get(Arrays.toString(c)).add(str);
        }
        ArrayList<List<String>> output = new ArrayList<>();
        for(ArrayList<String> ls : map.values()){
            output.add(ls);
        }
        return output;
    }

    public int[] topKFrequent(int[] nums, int k) {
        if(k> nums.length){
            return null;
        }
        HashMap<Integer,Integer> countMap = new HashMap<>();
        List<Integer>[] ls = new ArrayList[nums.length];
        List<Integer> list=new ArrayList<>();
        for(int i : nums){
            countMap.putIfAbsent(i,0);
            countMap.put(i, countMap.get(i)+1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()){
            int val = entry.getValue();
            if(ls[val]==null){
                ls[val]=new ArrayList<>();
            }
            ls[val].add(entry.getKey());
        }
        for(int i = ls.length-1;i>=0 ;i--){
            if(ls[i]==null){continue;}
            for(int j=0;j<ls[i].size();j++){
                list.add(ls[i].get(j));
                k--;
                if(k<=0){
                    return list.stream().mapToInt(g->g).toArray();
                }
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }

    public int[] productExceptSelf(int[] nums) {
        int pref=1,post=1;
        int[] ans = new int[nums.length];
        ans[0]=1;
        for(int i=0;i<nums.length-1;i++){
            pref=pref*nums[i];
            ans[i+1]=pref;

        }
        for(int i= nums.length-2;i>=0;i--){
            post=post*nums[i+1];
            ans[i]=ans[i]*post;
        }
        return ans;
    }

    public String encode(List<String> strs) {
        StringBuilder encodedText = new StringBuilder();
        for(String str :strs){
            int len = str.length();
            encodedText.append(len).append('#').append(str);
        }
        Misc misc = new Misc();
        System.out.println((misc.decode(encodedText.toString())));
        return encodedText.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedText = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for(int i=0;i<str.length();i++){
            while(Character.isDigit(str.charAt(i))){
                s.append(str.charAt(i));
                i++;
            }
            i++;
            int len = Integer.parseInt(s.toString());
            s=new StringBuilder();
            decodedText.add(str.substring(i , i + len));
            i = i + len-1;
        }
        return decodedText;
    }
    public int longestConsecutive(int[] nums) {
        Set<Integer> map = new HashSet<>();
        for(int i : nums){
            map.add(i);
        }
        int max=0;
        for(int i=0;i<nums.length;i++) {
            if (!map.contains(nums[i] - 1)) {
                int localMax = 0;
                int val = nums[i];
                while (map.contains(val++)) {
                    localMax++;
                }
                max = Math.max(max, localMax);
            }
        }
        return max;

    }

    public boolean isPalindrome(String s) {
        StringBuilder strBuilder = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))){
                strBuilder.append(s.charAt(i));
            }
        }
        String str =strBuilder.toString().toLowerCase();
        int i=0,j=str.length()-1;
        while (i<j){
            if(str.charAt(i)!=str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


}
