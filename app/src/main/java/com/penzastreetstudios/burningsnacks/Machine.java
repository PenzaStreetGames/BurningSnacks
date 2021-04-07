package com.penzastreetstudios.burningsnacks;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.penzastreetstudios.burningsnacks.adapters.QueueAdapter;
import com.penzastreetstudios.burningsnacks.adapters.SnackAdapter;
import com.penzastreetstudios.burningsnacks.snacks.ISnack;
import com.penzastreetstudios.burningsnacks.students.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.LogRecord;

public class Machine {
    int id;
    public Map<String, Integer> snacks = new HashMap<>();
    public Map<String, ISnack> snackKinds = new HashMap<>();
    public ArrayList<Student> queue = new ArrayList<>();
    public String name;
    public String status;
    public int sum;
    public Student student;
    //public QueueProcess process;
    public Thread thread;
    public MachineFragment fragment;
    public MachineFragment bigFragment;

    public Machine(int id) {
        this.id = id;
        name = "Автомат " + (id + 1);
        status = "Простаивает";
        thread = new Thread(new QueueThread(this, handler));
    }

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            updateView();
        }
    };

    public void updateView() {
        if (fragment != null)
            fragment.updateView();
        if (bigFragment != null)
            bigFragment.updateView();
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

    public void setFragment(MachineFragment fragment) {
        this.fragment = fragment;
        fragment.setMachine(this);
    }

    public void setBigFragment(MachineFragment fragment) {
        bigFragment = fragment;
        bigFragment.setMachine(this);
    }
}
