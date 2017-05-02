package com.example.a127107.demoexplicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HeroStatsActivity extends AppCompatActivity {
    TextView tvName, tvStrength, tvTechnicalProwess;
    Button btnLike, btnDislike;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_stats);

        //get intent
        Intent i = getIntent();
        //get hero object first activity put in intetnt
        hero hero = (hero) i.getSerializableExtra("intentKey");

        tvName = (TextView)findViewById(R.id.textViewName);
        tvStrength = (TextView)findViewById(R.id.textViewStrength);
        tvTechnicalProwess = (TextView)findViewById(R.id.textViewTechnical);

        btnLike = (Button)findViewById(R.id.buttonLike);
        btnDislike = (Button)findViewById(R.id.buttonDislike);

        //use getters of hero object to get the attributes
        tvName.setText(hero.getName());
        tvStrength.setText("Strength: "+hero.getStrength());
        tvTechnicalProwess.setText("Technical: "+ hero.getTechnicalProwess());


        //when button like is click set result
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create intent and pass in string data
                Intent i = new Intent();
                i.putExtra("like","like");
                //set the result to RESULT_OK to indicate normal
                //response and pass in the intent containing like
                setResult(RESULT_OK,i);
                finish();
            }
        });

        //dislike button onClick
        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent and pass in string data
                Intent i = new Intent();
                i.putExtra("like","dislike");
                setResult(RESULT_OK,i);
                finish();
            }
        });




    }
}
