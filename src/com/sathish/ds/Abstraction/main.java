package com.sathish.ds.Abstraction;

public class main {
    public static void main(String[] args) {
        Cat cat  = new Cat("cat","fish");
        Tiger tiger = new Tiger("Tiger","meat");
        tiger.feed();
        cat.feed();
        cat.pet();
    }

}
