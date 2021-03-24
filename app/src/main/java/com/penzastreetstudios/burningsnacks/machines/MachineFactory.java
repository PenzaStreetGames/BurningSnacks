package com.penzastreetstudios.burningsnacks.machines;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.penzastreetstudios.burningsnacks.Machine;

public class MachineFactory {
    public static int increment = 0;

    public static Machine create(TextView name, TextView status, TextView student,
                                 RecyclerView snacks, RecyclerView queue, TextView sum) {
        return new Machine(increment++, name, status, student, snacks, queue, sum);
    }
}
