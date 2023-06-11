package com.sathish.ds.Abstraction;

public class Tiger extends Animal{
    public Tiger(String animalName, String food) {
        super(animalName, food);
    }

    @Override
    public void feed() {
        System.out.println("Feeding Food : "+this.animalFood +" for animal : "+this.animalName);
    }
}
