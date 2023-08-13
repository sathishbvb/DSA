package com.sathish.neetcode.Arrays;

import java.util.HashMap;
import java.util.HashSet;

public class SlidingWindow {
    public static void main(String[] args) {
        SlidingWindow sw = new SlidingWindow();
        System.out.println(sw.lengthOfLongestSubstring("pwwkew"));
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

}
