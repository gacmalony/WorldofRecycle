package com.example.worldofrecycle.NormalView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.worldofrecycle.R;

import java.util.ArrayList;

public class NormalRecycle extends AppCompatActivity {

    RecyclerView normal_recycler;

    private PlanetAdapter adapter;
    private ArrayList<Planets> planetArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_recycle);
        normal_recycler = findViewById(R.id.normal_reyc);

        normal_recycler.setLayoutManager(new LinearLayoutManager(this));
        planetArrayList = new ArrayList<>();
        adapter = new PlanetAdapter(this, planetArrayList);
        normal_recycler.setAdapter(adapter);
        normal_recycler.addItemDecoration(new DividerItemDecoration(this,
                LinearLayoutManager.VERTICAL));

        createListData();


    }

    private void createListData() {


        Planets planet = new Planets("Earth", 150,10,12750);
        planetArrayList.add(planet);

        // Adding some other info
        planet = new Planets("Jupiter", 778, 26, 143000);
        planetArrayList.add(planet);
        planet = new Planets("Mars", 228, 4, 6800);
        planetArrayList.add(planet);
        planet = new Planets("Pluto", 5900, 1, 2320);
        planetArrayList.add(planet);
        planet = new Planets("Venus", 108, 9, 12750);
        planetArrayList.add(planet);
        planet = new Planets("Saturn", 1429, 11, 120000);
        planetArrayList.add(planet);
        planet = new Planets("Mercury", 58, 4, 4900);
        planetArrayList.add(planet);
        planet = new Planets("Neptune", 4500, 12, 50500);
        planetArrayList.add(planet);
        planet = new Planets("Uranus", 2870, 9, 52400);
        planetArrayList.add(planet);

        adapter.notifyDataSetChanged();





}}

