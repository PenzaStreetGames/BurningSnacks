package com.penzastreetstudios.burningsnacks.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.penzastreetstudios.burningsnacks.R;

import java.util.ArrayList;
import java.util.Map;

public class SnackAdapter extends RecyclerView.Adapter<SnackAdapter.SnackViewHolder> {

    private ArrayList<String> snacks = new ArrayList<>();

    @NonNull
    @Override
    public SnackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.snack_item, parent, false);
        return new SnackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SnackViewHolder holder, int position) {
        holder.bind(snacks.get(position));
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return snacks.size();
    }

    class SnackViewHolder extends RecyclerView.ViewHolder {
        private TextView snackCategory;

        public SnackViewHolder (View ItemView) {
            super(ItemView);
            snackCategory = ItemView.findViewById(R.id.snackItem);
        }

        public void bind(String snackName) {
            snackCategory.setText(snackName);
            snackCategory.setVisibility((snackName.equals("")) ? View.GONE : View.VISIBLE);
        }
    }

    public void setItems(Map<String, Integer> snacks) {
        for (String key : snacks.keySet()) {
            this.snacks.add(key + " " + snacks.get(key));
        }
        notifyDataSetChanged();
    }

    public void clearItems() {
        snacks.clear();
        notifyDataSetChanged();
    }
}
