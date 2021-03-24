package com.penzastreetstudios.burningsnacks.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.penzastreetstudios.burningsnacks.R;
import com.penzastreetstudios.burningsnacks.students.Student;

import java.util.ArrayList;

public class QueueAdapter extends RecyclerView.Adapter<QueueAdapter.QueueViewHolder> {

    private ArrayList<String> queue = new ArrayList<>();

    @NonNull
    @Override
    public QueueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.queue_item, parent, false);
            return new QueueViewHolder(view);
            }

    @Override
    public void onBindViewHolder(@NonNull QueueViewHolder holder, int position) {
            holder.bind(queue.get(position));
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return queue.size();
    }

    class QueueViewHolder extends RecyclerView.ViewHolder {
        private TextView queueCategory;

        public QueueViewHolder (View ItemView) {
            super(ItemView);
            queueCategory = ItemView.findViewById(R.id.queueItem);
        }

        public void bind(String queueName) {
            queueCategory.setText(queueName);
            queueCategory.setVisibility((queueName.equals("")) ? View.GONE : View.VISIBLE);
        }
    }

    public void setItems(ArrayList<Student> students) {
        for (Student student : students) {
            this.queue.add(student.getName());
        }
        notifyDataSetChanged();
    }

    public void clearItems() {
        queue.clear();
        notifyDataSetChanged();
    }
}
