package org.example.task4.models;

import javax.persistence.*;
import java.util.Random;
@Entity
@Table(name = "Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int duration;

    private static final String[] titles = new String[] {"Математика, История, Биология, Информатика"};
    private static final Random random = new Random();

    public Course(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public Course() {
    }


    public static Course create(){
        return new Course(titles[random.nextInt(titles.length)],
                random.nextInt(20, 26));
    }



    public void updateDuration(){
        duration = random.nextInt(20, 26);
    }

    public void updateTitle(){
        title = titles[random.nextInt(titles.length)];
    }



    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}


