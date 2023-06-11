package com.sathish.ds.Abstraction;

public class Cat extends Animal implements IDomesticAnimal{

    public Cat(String animalName, String food) {
        super(animalName, food);
    }

    @Override
    public void feed() {
        System.out.println("Feeding Food : "+this.animalFood +" for animal : "+this.animalName);
    }

    @Override
    public void pet() {
        System.out.println("Petting animal : "+this.animalName);
    }
}
