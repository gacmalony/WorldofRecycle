package com.example.worldofrecycle.singleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.worldofrecycle.R;

import java.util.ArrayList;

public class SingleRecycleAdapter extends RecyclerView.Adapter<SingleRecycleAdapter.MyViewHolder> {

    private ArrayList<SingleRecModel> arrayList;

    private Context context;

    private int checked = 0;

    public SingleRecycleAdapter(ArrayList<SingleRecModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    public void SetChoiced(ArrayList<SingleRecModel> singleRecModels){
        this.arrayList = new ArrayList<>();
        this.arrayList = singleRecModels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.single_name);
            image = itemView.findViewById(R.id.single_image);
        }

        void bind(final SingleRecModel model) {
            if (checked == -1) {
                image.setVisibility(View.GONE);
            } else {
                if (checked == getAdapterPosition()) {
                    image.setVisibility(View.VISIBLE);
                } else {
                    image.setVisibility(View.GONE);
                }
            }

            txt.setText(model.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    image.setVisibility(View.VISIBLE);
                    if (checked != getAdapterPosition()){
                        notifyItemChanged(checked);
                        checked = getAdapterPosition();
                    }
        }
    });
        }
    }


    public SingleRecModel getSelected(){
        if (checked != -1){
            return arrayList.get(checked);
        }
        return null;
    }

}

