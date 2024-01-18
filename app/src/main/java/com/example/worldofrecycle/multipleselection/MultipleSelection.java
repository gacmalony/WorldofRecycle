package com.example.worldofrecycle.multipleselection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.worldofrecycle.R;
import com.example.worldofrecycle.singleview.SingleRecModel;

import java.util.ArrayList;

public class MultipleSelection extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<SingleRecModel> data;
    private MultipleSelAdapter adapter;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_selection);

        recyclerView = findViewById(R.id.recyclerViewselection);
        btn = findViewById(R.id.buttonselection);
        data = new ArrayList<>();
        adapter = new MultipleSelAdapter(this, data);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        CreateListOfData();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adapter.getSelected().size() > 0){
                    StringBuilder stringBuilder = new StringBuilder();

                    for (int i=0; i<adapter.getSelected().size(); i++){
                        stringBuilder.append(adapter.getSelected().get(i).getName());
                        stringBuilder.append("\n");
                    }
                    ShowToast(""+stringBuilder.toString().trim());
                }else{
                    ShowToast("No Selection");
                }
            }
        });

    }

    private void CreateListOfData() {
        data = new ArrayList<>();
        for (int i= 0; i<20; i++){
            SingleRecModel singleRecModel = new SingleRecModel();
            singleRecModel.setName("Employee"+ (i+1));

            if (i == 0){
                singleRecModel.setChecked(true);
            }
            data.add(singleRecModel);
        }
        adapter.setSelection(data);
    }

    private void ShowToast(String str){
        Toast.makeText(getApplicationContext(), ""+str,Toast.LENGTH_LONG).show();
    }
}