package org.example.task4;



import org.example.task4.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Program {
    /**
     * Задача 1
     * ========
     * <p>
     * Используя SQL, создайте таблицу students с полями id (ключ), name, и age.
     * Реализация подключения к базе данных через JDBC:
     * Напишите Java-код для подключения к базе данных (например, MySQL или PostgreSQL).
     * Реализуйте вставку, чтение, обновление и удаление данных в таблице Students
     * с использованием провайдера JDBC.
     */
    private final static Random random = new Random();

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "password";

        try {
            // Подключение к базе данных
            Connection connection = DriverManager.getConnection(url, user, password);

            // Создание базы данных
            createDatabase(connection);
            System.out.println("Database created successfully");

            // Использование базы данных
            useDataBase(connection);
            System.out.println("Use database successfully");

            // Создание таблицы
            createTable(connection);
            System.out.println("Create table successfully");

            // Вставка данных
            int count = random.nextInt(5, 11);
            for (int i = 0; i < count; i++){
                insertData(connection, Student.create());
            }
            System.out.println("Insert data successfully");

            // Чтение данных
            Collection<Student> students = readData(connection);
            for (var student: students) System.out.println(student);
            System.out.println("Read data successfully");

            // Обновление данных
            for (var student: students) {
                student.updateName();
                student.updateAge();
                updateData(connection, student);
            }
            System.out.println("Update data successfully");







        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    private static void createDatabase(Connection connection) throws SQLException{
        String createDataBaseSQl = "CREATE DATABASE IF NOT EXISTS schoolDB;";

        PreparedStatement statement = connection.prepareStatement(createDataBaseSQl);
        statement.execute();

    }
    private static void useDataBase(Connection connection) throws SQLException{
        String useDataBaseSQL = "USE schoolDB;";
        try (PreparedStatement statement = connection.prepareStatement(useDataBaseSQL)) {
            statement.execute();
        }
    }
    private static void createTable(Connection connection) throws SQLException{
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Courses " +
                "(id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255), duration INT);";
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.execute();
        }

    }

    /**
     * Добавление данных в таблицу students
     * @param connection Соединение с БД
     * @param student Студент
     * @throws SQLException Исключение при выполнении запроса
     */
    private static void insertData(Connection connection, Student student) throws SQLException {
        String insertDataSQL = "INSERT INTO Courses (title, duration) VALUES (?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(insertDataSQL)) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.executeUpdate();
        }
    }
    /**
     * Чтение данных из таблицы students
     * @param connection Соединение с БД
     * @return Коллекция студентов
     * @throws SQLException Исключение при выполнении запроса
     */
    private static Collection<Student> readData(Connection connection) throws SQLException {
        ArrayList<Student> studentsList = new ArrayList<>();
        String readDataSQL = "SELECT * FROM Courses;";
        try (PreparedStatement statement = connection.prepareStatement(readDataSQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("title");
                int age = resultSet.getInt("duration");
                studentsList.add(new Student(id, name, age));
            }
            return studentsList;
        }
    }
    /**
     * Обновление данных в таблице students по идентификатору
     * @param connection Соединение с БД
     * @param student Студент
     * @throws SQLException Исключение при выполнении запроса
     */
    private static void updateData(Connection connection, Student student) throws SQLException {
        String updateDataSQL = "UPDATE Courses SET title=?, duration=? WHERE id=?;";
        try (PreparedStatement statement = connection.prepareStatement(updateDataSQL)) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setInt(3, student.getId());
            statement.executeUpdate();
        }
    }
}
