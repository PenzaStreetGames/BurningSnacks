package com.penzastreetstudios.burningsnacks.students;

public class Student {
    public int id;

    public Student(int id) {
        this.id = id;
    }

    public String getName() {
        return "Студент " + id;
    }
}
