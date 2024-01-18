package com.example.worldofrecycle.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.worldofrecycle.R;

import java.util.ArrayList;

public class CardViewActivity extends AppCompatActivity {


    private CardAdapter adapter;
    private RecyclerView recycle;
    private ArrayList<PlanetsCards> planetsCardsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view2);

        planetsCardsArrayList = new ArrayList<>();

        adapter = new CardAdapter(planetsCardsArrayList, CardViewActivity.this);

        recycle = findViewById(R.id.JustRecycle);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        recycle.setAdapter(adapter);
        CreateDataforRecycle();


    }

    private void CreateDataforRecycle() {
        PlanetsCards planet = new PlanetsCards("Earth", 150,10,12750);
        planetsCardsArrayList.add(planet);
        planet = new PlanetsCards("Jupiter", 778, 26, 143000);
        planetsCardsArrayList.add(planet);
        planet = new PlanetsCards("Mars", 228, 4, 6800);
        planetsCardsArrayList.add(planet);
        planet = new PlanetsCards("Pluto", 5900, 1, 2320);
        planetsCardsArrayList.add(planet);
        planet = new PlanetsCards("Venus", 108, 9, 12750);
        planetsCardsArrayList.add(planet);
        planet = new PlanetsCards("Saturn", 1429, 11, 120000);
        planetsCardsArrayList.add(planet);
        planet = new PlanetsCards("Mercury", 58, 4, 4900);
        planetsCardsArrayList.add(planet);
        planet = new PlanetsCards("Neptune", 4500, 12, 50500);
        planetsCardsArrayList.add(planet);
        planet = new PlanetsCards("Uranus", 2870, 9, 52400);
        planetsCardsArrayList.add(planet);

        adapter.notifyDataSetChanged();
    }
}