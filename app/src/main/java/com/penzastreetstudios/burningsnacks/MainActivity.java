package com.penzastreetstudios.burningsnacks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.penzastreetstudios.burningsnacks.adapters.QueueAdapter;
import com.penzastreetstudios.burningsnacks.adapters.SnackAdapter;
import com.penzastreetstudios.burningsnacks.machines.MachineFactory;

public class MainActivity extends AppCompatActivity {

    public Mirea mirea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mirea = new Mirea();
        start();
    }

    public void start() {
        mirea.machines.add(
                MachineFactory.create(
                        findViewById(R.id.name1),
                        findViewById(R.id.status1),
                        findViewById(R.id.student1),
                        findViewById(R.id.snacks1),
                        findViewById(R.id.queue1),
                        findViewById(R.id.sum1))
        );
        mirea.machines.add(
                MachineFactory.create(
                        findViewById(R.id.name2),
                        findViewById(R.id.status2),
                        findViewById(R.id.student2),
                        findViewById(R.id.snacks2),
                        findViewById(R.id.queue2),
                        findViewById(R.id.sum2))
        );
        mirea.machines.add(
                MachineFactory.create(
                        findViewById(R.id.name3),
                        findViewById(R.id.status3),
                        findViewById(R.id.student3),
                        findViewById(R.id.snacks3),
                        findViewById(R.id.queue3),
                        findViewById(R.id.sum3))
        );
        mirea.machines.add(
                MachineFactory.create(
                        findViewById(R.id.name4),
                        findViewById(R.id.status4),
                        findViewById(R.id.student4),
                        findViewById(R.id.snacks4),
                        findViewById(R.id.queue4),
                        findViewById(R.id.sum4))
        );
        for (int i = 0; i < mirea.machines.size(); i++) {
            Machine machine = mirea.machines.get(i);
            machine.snackAdapter = new SnackAdapter();
            machine.snacksField.setAdapter(machine.snackAdapter);
            machine.snacksField.setLayoutManager(new LinearLayoutManager(this));
            machine.queueAdapter = new QueueAdapter();
            machine.queueField.setLayoutManager(new LinearLayoutManager(this));
            machine.queueField.setAdapter(machine.queueAdapter);
        }

        mirea.start();
    }


}