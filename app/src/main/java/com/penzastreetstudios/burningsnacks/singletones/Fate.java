package com.penzastreetstudios.burningsnacks.singletones;

import com.penzastreetstudios.burningsnacks.Machine;
import com.penzastreetstudios.burningsnacks.students.Student;
import com.penzastreetstudios.burningsnacks.students.StudentFactory;

import java.util.ArrayList;
import java.util.Random;

public class Fate {
    private static Fate fate = null;

    public static Fate getFate() {
        if (fate == null)
            fate = new Fate();
        return fate;
    }

    public void send(ArrayList<Machine> machines, int studentsAmount) {
        Random r = new Random();
        for (int i = 0; i < studentsAmount; i++) {
            int index = r.nextInt(4);
            Student student = StudentFactory.create();
            machines.get(index).addStudent(student);
        }
    }

    private Fate() {}
}
