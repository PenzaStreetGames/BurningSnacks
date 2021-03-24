package com.penzastreetstudios.burningsnacks;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.penzastreetstudios.burningsnacks.adapters.QueueAdapter;
import com.penzastreetstudios.burningsnacks.adapters.SnackAdapter;
import com.penzastreetstudios.burningsnacks.snacks.ISnack;
import com.penzastreetstudios.burningsnacks.students.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Machine {
    int id;
    public Map<String, Integer> snacks = new HashMap<>();
    public Map<String, ISnack> snackKinds = new HashMap<>();
    public ArrayList<Student> queue = new ArrayList<>();
    public String name;
    public String status;
    public int sum;
    public SnackAdapter snackAdapter;
    public QueueAdapter queueAdapter;
    public Student student;
    TextView nameField;
    TextView statusField;
    TextView studentField;
    RecyclerView snacksField;
    RecyclerView queueField;
    TextView sumField;
    public QueueProcess process;

    public Machine(int id, TextView nameField, TextView statusField, TextView studentField,
                   RecyclerView snacksField, RecyclerView queueField, TextView sumField) {
        this.id = id;
        this.nameField = nameField;
        this.statusField = statusField;
        this.studentField = studentField;
        this.snacksField = snacksField;
        this.queueField = queueField;
        this.sumField = sumField;
        name = "Автомат " + id;
        status = "Простаивает";
    }

    public void updateView() {
        nameField.setText(name);
        statusField.setText(getStatus());
        studentField.setText(getStudent());
        snackAdapter.clearItems();
        snackAdapter.setItems(snacks);
        queueAdapter.clearItems();
        queueAdapter.setItems(queue);
        sumField.setText(Integer.toString(sum));
    }

    public void addSnack(ISnack snack) {
        String name = snack.getName();
        int value = 0;
        if (snacks.get(name) != null) {
            value = snacks.get(name);
        }
        snacks.put(name, value + 1);
        if (snackKinds.get(name) == null)
            snackKinds.put(name, snack);
    }

    public void getSnack() {
        int bound = snacks.size();
        Random r = new Random();
        int index = r.nextInt(bound);
        String snackName = (String) snacks.keySet().toArray()[index];
        int snackValue = snacks.get(snackName);
        snacks.put(snackName, snackValue - 1);
        sum += snackKinds.get(snackName).getPrice();
        if (snacks.get(snackName) == 0)
            snacks.remove(snackName);
    }

    public void clearSum () {
        sum = 0;
    }

    public void addStudent(Student student) {
        queue.add(student);
    }

    public String getStatus() {
        return status;
    }

    public String getStudent() {
        if (student == null)
            return "Пусто";
        return student.getName();
    }
}
