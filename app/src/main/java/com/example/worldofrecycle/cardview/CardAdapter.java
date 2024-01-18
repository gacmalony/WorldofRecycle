package com.example.worldofrecycle.cardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.worldofrecycle.R;

import java.util.ArrayList;
import java.util.Locale;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder>{
    private ArrayList<PlanetsCards> planets;

    private Context context;
    public CardAdapter(ArrayList<PlanetsCards> planets, Context context) {
        this.planets = planets;
        this.context = context;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PlanetsCards planetsCards = planets.get(position);
        holder.setDetails(planetsCards);

    }

    @Override
    public int getItemCount() {
        return planets.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txt;
        TextView txt1;
        TextView txt2,txt3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.cardtext1);
            txt1 = itemView.findViewById(R.id.cardtext2);
            txt2 = itemView.findViewById(R.id.cardtext3);
            txt3 = itemView.findViewById(R.id.cardtext4);
        }


        void setDetails(PlanetsCards planetsCards){
            txt.setText(planetsCards.getPlanetName2());
            txt1.setText(String.format(Locale.GERMANY,"Surface Gravity : %d N/Kg", planetsCards.getGravity2()));
            txt2.setText(String.format(Locale.GERMANY,"Distance from Sun : %d Million km", planetsCards.getDistance2()));
            txt3.setText(String.format(Locale.GERMANY,"Diamter : %d  km", planetsCards.getDiameter2()));
        }

        @Override
        public void onClick(View v) {
            String sw = switch (getLayoutPosition()){
                case 0 -> "First one";
                case 1 -> "Second one";
                case 2 -> "Third one";
                case 3 -> "Fourth one";
                case 4 -> "Fifth one";
                case 5 -> "Sixth one";
                default-> "Which one :)";

            };
                Toast.makeText(context.getApplicationContext(), "You clicked"+sw+"one", Toast.LENGTH_SHORT).show();


        }
    }
}
