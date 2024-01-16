package org.example.task2;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//
//Создайте абстрактный класс "Animal" с полями "name" и "age".
//Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
//Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
//Выведите на экран информацию о каждом объекте.
//Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.



public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Cat("Василий"), new Dog("Лайка")};

        for (Animal animal : animals) {
            Class<? extends Animal> animalClass = animal.getClass();
            Field[] fields = animalClass.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }
            Method[] methods = animalClass.getMethods();
            for (Method method : methods) {
                System.out.println(method);
            }

            System.out.println();
            try {
                Method printSerialNumber = animalClass.getDeclaredMethod("makeSound");
                System.out.println(printSerialNumber);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        }
    }
}
