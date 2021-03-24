package com.penzastreetstudios.burningsnacks.students;

public class StudentFactory {
    static int increment = 0;

    static public Student create() {
        return new Student(increment++);
    }
}
