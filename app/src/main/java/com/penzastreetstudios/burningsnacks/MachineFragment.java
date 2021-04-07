package com.penzastreetstudios.burningsnacks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.penzastreetstudios.burningsnacks.adapters.QueueAdapter;
import com.penzastreetstudios.burningsnacks.adapters.SnackAdapter;

public class MachineFragment extends Fragment {

    public Machine machine;
    public QueueAdapter queueAdapter;
    public SnackAdapter snackAdapter;

    public TextView nameField;
    public TextView statusField;
    public TextView studentField;
    public RecyclerView snacksField;
    public RecyclerView queueField;
    public TextView sumField;

    MachineFragment thisFragment = this;

    public boolean fullscreen;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.machine_frame, container, false);
        nameField = view.findViewById(R.id.name);
        statusField = view.findViewById(R.id.status);
        studentField = view.findViewById(R.id.student);
        snacksField = view.findViewById(R.id.snacks);
        queueField = view.findViewById(R.id.queue);
        sumField = view.findViewById(R.id.sum);

        snackAdapter = new SnackAdapter();
        snacksField.setAdapter(snackAdapter);
        snacksField.setLayoutManager(new LinearLayoutManager(getContext()));
        queueAdapter = new QueueAdapter();
        queueField.setLayoutManager(new LinearLayoutManager(getContext()));
        queueField.setAdapter(queueAdapter);

        fullscreen = false;

        view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!fullscreen) {
                            ((MainActivity)getActivity()).makeFullScreen(thisFragment);
                        }
                    }
                });

        updateView();

        return view;
    }

    public void updateView() {
        nameField.setText(machine.name);
        statusField.setText(machine.getStatus());
        studentField.setText(machine.getStudent());
        snackAdapter.clearItems();
        snackAdapter.setItems(machine.snacks);
        queueAdapter.clearItems();
        queueAdapter.setItems(machine.queue);
        sumField.setText(Integer.toString(machine.sum));
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }
}
