package com.example.worldofrecycle;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.worldofrecycle.MultipleView.MultipleViewActivity;
import com.example.worldofrecycle.NormalView.NormalRecycle;
import com.example.worldofrecycle.cardview.CardViewActivity;
import com.example.worldofrecycle.multipleselection.MultipleSelection;
import com.example.worldofrecycle.singleview.SingleActivity;


public class MainActivity extends AppCompatActivity {
    Animation anim;
    Button btn1, btn2, btn3, btn4, btn5, btn6;

    // SwipeRevealLayout dependecy doesnt work, if i can find to the issue, i will add Swipe functionality again.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anim = AnimationUtils.loadAnimation(this,R.anim.anime);
        btn1 = findViewById(R.id.button1);
        btn1.setAnimation(anim);
        btn2 = findViewById(R.id.button2);
        btn2.setAnimation(anim);
        btn3 = findViewById(R.id.button3);
        btn3.setAnimation(anim);
        btn4 = findViewById(R.id.button4);
        btn4.setAnimation(anim);
        btn5 = findViewById(R.id.button5);
        btn5.setAnimation(anim);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transfer();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transfercard();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            transferSingle();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transferMultiple();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transferMultipleSel();
            }
        });



    }




    public void transfer(){

    Intent i = new Intent(getApplicationContext(), NormalRecycle.class);
    startActivity(i);
    }

    public void transfercard(){
        Intent i = new Intent(getApplicationContext(), CardViewActivity.class);
        startActivity(i);
    }


    private void transferSingle() {
        Intent i = new Intent(getApplicationContext(), SingleActivity.class);
        startActivity(i);
    }

    private void transferMultiple(){
        Intent i = new Intent(getApplicationContext(), MultipleViewActivity.class);
        startActivity(i);
    }

    private void transferMultipleSel() {
        Intent i = new Intent(getApplicationContext(), MultipleSelection.class);
        startActivity(i);
    }

}