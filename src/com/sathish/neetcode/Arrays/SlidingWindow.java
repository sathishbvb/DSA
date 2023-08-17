package com.sathish.neetcode.Arrays;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

public class SlidingWindow {
    public static void main(String[] args) {
        SlidingWindow sw = new SlidingWindow();
//        System.out.println(sw.lengthOfLongestSubstring("pwwkew"));
//        System.out.println(sw.characterReplacement("ABABBA",1));
//        System.out.println(sw.checkInclusion("ab","eidbaooo"));
        System.out.println(sw.minWindow("ADOBECODEBANC","ABC"));
    }

    public int lengthOfLongestSubstring1(String s) {
        if(s.equals(" ")){
            return 1;
        }
        if(s.length()==1){
            return s.length();
        }
        int max=0,i=0;int j = i+1;
        char[] ch = s.toCharArray();
        HashSet<Character> set = new HashSet();
        while(j<ch.length){
            set.add(ch[i]);
            while(j<ch.length && set.add(ch[j])){
               j++;
            }
            max=Math.max((j-i),max);
            i=i+1;
            j=i+1;
            set=new HashSet<>();
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s){
        if(s.equals(" ")){
            return 1;
        }
        if(s.length()==1){
            return s.length();
        }
        HashSet<Character> set = new HashSet();
        char[] ch = s.toCharArray();
        int max=0,i=0,j =0;
        while(j<ch.length){
            while(set.contains(ch[j])){
                set.remove(ch[i]);
                i++;
            }
            set.add(ch[j]);
            max=Math.max(max,j-i+1);
            j++;

        }
        return max;
    }

    //given a string and an int value ,replace at most int character in string to form a substring
    //Return length of max substring

    public int characterReplacement(String s, int k) {
        char ch[] = s.toCharArray();
        int i=0,j=0,res=0,max=0;
        if(s.length()<k){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        while(j<ch.length){
                map.put(ch[j],(map.getOrDefault(ch[j],0))+1);
            while((((j-i)+1)-getMaxValFromMap(map))>k){
                map.put(ch[i],map.get(ch[i])-1);
                i++;
            }
            res=Math.max(res,(j-i)+1);
            j++;

        }
        return res;
    }

    private int getMaxValFromMap(HashMap<Character,Integer> map) {
        int max=0;
        for(char c : map.keySet()){
            max=Math.max(max,map.get(c));
        }
        return max;
    }

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int[] freq = new int[26];
        int m = s2.length();
        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
        }
        int[] freq2 = new int[26];
        for (int i = 0; i < m; i++) {
            freq2[s2.charAt(i) - 'a']++;
            if (i >= n) {
                freq2[s2.charAt(i - n) - 'a']--;
            }
            if (Arrays.equals(freq, freq2))
                return true;
        }
        return false;
    }


//    Given two strings s and t of lengths m and n respectively, return the minimum window substring
//    of s such that every character in t (including duplicates) is included in the window. If there is no such substring,
//    return the empty string "".
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        HashMap<Character,Integer> tMap = new HashMap<>();
        HashMap<Character,Integer> sMap = new HashMap<>();
        for(char c : t.toCharArray()){
            tMap.put(c,tMap.getOrDefault(s,0)+1);
        }
        int i=0,j=0;
        String str=s+t;
        while(j<s.length()){
            while(j<s.length()&& !tMap.equals(sMap)){
                if(tMap.containsKey(s.charAt(j))){
                    sMap.put(s.charAt(j),sMap.getOrDefault(s.charAt(j),0)+1);
                }
                j++;
            }
            String s1 = s.substring(i,j);
            str=str.length()>s1.length()?s1:str;
            sMap=new HashMap<>();
            i++;
            j=i;
        }
        return str;
    }
}
