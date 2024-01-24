package org.example.task3;

 /* Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
Обеспечьте поддержку сериализации для этого класса.
Создайте объект класса Student и инициализируйте его данными.
Сериализуйте этот объект в файл.
Десериализуйте объект обратно в программу из файла.
Выведите все поля объекта, включая GPA, и ответьте на вопрос,
почему значение GPA не было сохранено/восстановлено.
*/


import java.io.*;

public class Main {
    public static void main(String[] args) {

        Student student = new Student("Василий", 22, 3.1);

        try(FileOutputStream fileOut = new FileOutputStream("file.bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(student);
            System.out.println("Объект сериализован.");
        }
        catch (IOException e){
            e.printStackTrace();
        }

        try(FileInputStream fileInput = new FileInputStream("file.bin");
            ObjectInputStream input = new ObjectInputStream(fileInput)) {
            Student student2;
            student2 = (Student)input.readObject();
            System.out.println("Объект десериализован");
            System.out.println(student2);
            System.out.println("Значения поля GPA = " + student2.GPA + " потому что оно было помечено идентификатором " +
                    "transient и изначально не сериализовалось в файл");

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }



    }
}
