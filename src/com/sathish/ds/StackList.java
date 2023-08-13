package com.sathish.ds;

import java.util.ArrayList;

public class StackList<T> {
    ArrayList<T> list;
    int i;

    public StackList(){
        this.list =new ArrayList<>(10);
        this.i=-1;
    }

    public void push(T value){
        this.i++;
        this.list.add(i,value);
    }
    public T pop(){
        if(i >= 0){
            return this.list.get(i--);
        }
        return null;
    }
    public T peek(){
        if(i >= 0){
            return this.list.get(i);
        }
        return null;
    }

    public Boolean isEmpty(){
        return i==-1;
    }

    public int size(){
        return i+1;
    }


}
