package com.sathish.neetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class QueueProblems {
    public static void main(String[] args) {
        QueueProblems q = new QueueProblems();
        System.out.println(q.countStudents(new int[]{1,1,1,0,0,1},new int[]{1,0,0,0,1,1}));
    }

    public int countStudents(int[] students, int[] sandwiches) {
        int ones=0,zeros=0;
        for(int st : students){
            if(st==0){zeros++;}
            else{ones++;}
        }
        for(int san : sandwiches){
            if(san==0){
                if(zeros==0){
                    return ones;
                }
                zeros--;
            }
            else{
                if(ones==0){
                    return zeros;
                }
                ones--;
            }
        }
        return 0;
    }
}
