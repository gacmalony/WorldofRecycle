package com.example.worldofrecycle.MultipleView;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.worldofrecycle.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MultipleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static int TYPE_CALL= 1;
    private static int TYPE_EMAIL=2;

    private ArrayList<MultiModel> data;
    private Context context;


    public MultipleAdapter(ArrayList<MultiModel> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view;

     if(viewType == TYPE_CALL){
         view = LayoutInflater.from(parent.getContext()).inflate(
                 R.layout.item_call, parent, false);
         return new CallViewHolder(view);
     }else{
         view = LayoutInflater.from(parent.getContext()).inflate(
                 R.layout.item_email, parent, false);
         return new EmailViewHolder(view);
     }}


    @Override
    public int getItemViewType(int position) {
        if (TextUtils.isEmpty(data.get(position).getEmail())) {
            return TYPE_CALL;
        } else{
            return TYPE_EMAIL;
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == TYPE_CALL){
            ((CallViewHolder) holder).SetCall(data.get(position));
        }else{
            ((EmailViewHolder) holder).SetEmail(data.get(position));
        }


    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class CallViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView address;
        public CallViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.callName);
            address = itemView.findViewById(R.id.callAddress);
        }

        public void SetCall(MultiModel multiModel){
            name.setText(multiModel.getName());
            address.setText(multiModel.getAdress());
        }
    }
    public class EmailViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView address;

        public EmailViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.emailName);
            address = itemView.findViewById(R.id.emailAddress);
        }


        public void SetEmail(MultiModel multiModel){
            name.setText(multiModel.getName());
            address.setText(multiModel.getAdress());
        }

    }

}
