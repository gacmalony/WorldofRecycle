package com.example.worldofrecycle.multipleselection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.worldofrecycle.MultipleView.MultiModel;
import com.example.worldofrecycle.MultipleView.MultipleAdapter;
import com.example.worldofrecycle.R;
import com.example.worldofrecycle.singleview.SingleRecModel;

import java.util.ArrayList;

public class MultipleSelAdapter extends RecyclerView.Adapter<MultipleSelAdapter.MultiViewHolder> {


    private Context context;
    private ArrayList<SingleRecModel> data;

    public MultipleSelAdapter(Context context, ArrayList<SingleRecModel> data) {
        this.context = context;
        this.data = data;
    }

    public void setSelection(ArrayList<SingleRecModel> data){
        this.data = new ArrayList<>();
        this.data = data;
        notifyDataSetChanged();

    }

    ArrayList<SingleRecModel> getAll() {
        return data;
    }


    public ArrayList<SingleRecModel> getSelected(){
        ArrayList<SingleRecModel> selected = new ArrayList<>();
        for (int i = 0 ; i<data.size() ; i++){
            if (data.get(i).isChecked()){
                selected.add(data.get(i));
            }
        }
        return selected;
    }

    @NonNull
    @Override
    public MultiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee,parent,false);
        return new MultiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MultiViewHolder holder, int position) {
        holder.bind(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class MultiViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        ImageView image;

        private int checked = 0;

        public MultiViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.single_name);
            image = itemView.findViewById(R.id.single_image);
        }

        void bind(final SingleRecModel singleRecModel) {
            image.setVisibility(singleRecModel.isChecked() ? View.VISIBLE : View.GONE);
            text.setText(singleRecModel.getName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    singleRecModel.setChecked(!singleRecModel.isChecked());
                    image.setVisibility(singleRecModel.isChecked() ? View.VISIBLE : View.GONE);
                }
            });
        }
    }



}