package org.example.task2;

public class Cat extends Animal{


    public Cat(String name) {
        super.name = name;
    }

    @Override
    public void voice() {
        System.out.println("Мяу");
    }

    public void makeSound(){
        System.out.println("Музыка мурчания");
    }


}
