package org.example.task2;

public class Dog extends Animal{

    public Dog(String name) {
        super.name = name;
    }

    @Override
    public void voice() {
        System.out.println("Гав-гав");
    }
}
