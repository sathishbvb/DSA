package com.sathish.ds.hashmap;

import java.security.Key;
import java.util.ArrayList;

public class HashMapImpl<K,V> {
    class Pair{
        K key;
        V val;
        void pair(K key,V val){
            this.key=key;
            this.val=val;
        }
    }

    ArrayList<Pair> list;
    int size;
    int capacity;

    public void HashMapImpl(){
        size=0;
        capacity=2;
        this.list=new ArrayList<>(capacity);

    }

    public void put(K key,V val){
        int number = getNumber(key);
        int index = getNumber(key) % (capacity / 2);
    }

    int getNumber(K key){
        int number=0;
        if(key instanceof String){
            for(char s : ((String) key).toCharArray()){
                number+= s;
            }
        }
        return number;
    }


}
