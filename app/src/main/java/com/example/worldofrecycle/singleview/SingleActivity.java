package com.example.worldofrecycle.singleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.worldofrecycle.R;

import java.util.ArrayList;

public class SingleActivity extends AppCompatActivity {

    private RecyclerView recycle;
    private SingleRecycleAdapter adapter;
    private ArrayList<SingleRecModel> data;

    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        data = new ArrayList<>();
        btn = findViewById(R.id.buttonsingle);
        recycle = findViewById(R.id.recyclerViewsingle);
        adapter = new SingleRecycleAdapter(data, this);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        recycle.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        CreateList();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adapter.getSelected() != null){
                    ShowToast(adapter.getSelected().getName());
                }else{
                    ShowToast("No selection");
                }
            }
        });
    }


    private void CreateList() {
        data = new ArrayList<>();
        for (int i = 0 ; i <20 ; i++){
            SingleRecModel employee = new SingleRecModel();
            employee.setName("Employee " + (i+1));
            data.add(employee);
        }
        adapter.SetChoiced(data);
    }

    private void ShowToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
