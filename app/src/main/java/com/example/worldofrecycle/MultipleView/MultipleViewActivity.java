package com.example.worldofrecycle.MultipleView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.worldofrecycle.R;

import java.util.ArrayList;

public class MultipleViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<MultiModel> data;
    MultipleAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_view);

        recyclerView = findViewById(R.id.recyclerViewMultiple);

        InsertData();

    }

    private void InsertData() {
        data = new ArrayList<>();
        MultiModel multiModel1 = new MultiModel();
        multiModel1.setName("Mert");
        multiModel1.setAdress("Karlsruhe");
        multiModel1.setEmail("+491234512312");
        data.add(multiModel1);

        MultiModel multiModel2 = new MultiModel();
        multiModel2.setName("Mert");
        multiModel2.setAdress("Berlin");
        multiModel2.setEmail("+491234512312");
        data.add(multiModel2);

        MultiModel multiModel3 = new MultiModel();
        multiModel3.setName("Mert");
        multiModel3.setAdress("Karlsruhe");
        multiModel3.setPhone("+491234512312");
        data.add(multiModel3);

        MultiModel multiModel4 = new MultiModel();
        multiModel4.setName("Mert");
        multiModel4.setAdress("Berlin");
        multiModel4.setPhone("+491234512312");
        data.add(multiModel4);

        adapter = new MultipleAdapter(data, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}