package com.penzastreetstudios.burningsnacks;

import android.os.AsyncTask;

import com.penzastreetstudios.burningsnacks.singletones.Delivery;
import com.penzastreetstudios.burningsnacks.singletones.Fate;

import java.util.ArrayList;

public class Mirea {
    public ArrayList<Machine> machines = new ArrayList<>();

    public void start() {
        fillMachines();
        Fate.getFate().send(machines, 20);
        //update();
        for (int i = 0; i < machines.size(); i++) {
            machines.get(i).thread.start();
            //machines.get(i).process = new QueueProcess();
            //machines.get(i).process.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, machines.get(i));
        }
    }

    public void fillMachines() {
        for (Machine machine : machines) {
            Delivery.getDelivery().fillAutomat(machine, 40);
        }
    }

    public void update() {
        for (Machine machine : machines) {
            machine.updateView();
        }
    }
}
