package com.penzastreetstudios.burningsnacks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

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

        for (int i = 0; i < 4; i++) {
            mirea.machines.add(MachineFactory.create());
            mirea.machines.get(i).setFragment(new MachineFragment());
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.frame1, mirea.machines.get(0).fragment);
        transaction.replace(R.id.frame2, mirea.machines.get(1).fragment);
        transaction.replace(R.id.frame3, mirea.machines.get(2).fragment);
        transaction.replace(R.id.frame4, mirea.machines.get(3).fragment);

        transaction.commit();

        mirea.start();
    }

    public void makeFullScreen(MachineFragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        MachineFragment newFragment = new MachineFragment();
        transaction.replace(R.id.fullscreenFrame, newFragment);
        fragment.machine.setBigFragment(newFragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }


}