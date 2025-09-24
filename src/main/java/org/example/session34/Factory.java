package org.example.session34;

interface Animal{
    void makeSound();
}
class Dog implements Animal{

    @Override
    public void makeSound() {
        System.out.println("bark bark");
    }
}
class Cat implements Animal{

    @Override
    public void makeSound() {
        System.out.println("miau miau");
    }
}
class Tiger implements Animal{

    @Override
    public void makeSound() {
        System.out.println("Roar");
    }
}

class AnimalFactory{
    public Animal createAnimal(String type){

        if (type.equalsIgnoreCase("dog")) return new Dog();
        else if (type.equalsIgnoreCase("cat")) return new Cat();
        else if (type.equalsIgnoreCase("tiger")) return new Tiger();

        return null;
    }
}


public class Factory {
    public static void main(String[] args) {
        AnimalFactory factory = new AnimalFactory();
        Animal dog = factory.createAnimal("dog");
        Animal cat = factory.createAnimal("cat");
        Animal tiger = factory.createAnimal("tiger");

        dog.makeSound();
        cat.makeSound();
        tiger.makeSound();
    }
}
