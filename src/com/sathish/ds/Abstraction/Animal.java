package com.sathish.ds.Abstraction;

public abstract class Animal {
    String animalName,animalFood;
    public Animal(String animalName,String food) {
        this.animalName=animalName;
        this.animalFood=food;
    }
    public abstract void feed();
}
