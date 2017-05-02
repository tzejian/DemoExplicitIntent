package com.example.a127107.demoexplicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {
    TextView tvBat,tvJoke;
    //request code to get status back from second activithy
    int requestCodeForBatmanStats = 1;
    int requestCodeForJokerStats = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvBat = (TextView)findViewById(R.id.tvBatman);
        tvJoke = (TextView) findViewById(R.id.tvJoker);

        //set listener to handle the clicking of batman textciew

        tvBat.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //create hero object of str 50 and technical 89
            hero batman = new hero("Detective",50,89);
            Intent i = new Intent(MainActivity.this,HeroStatsActivity.class);
            //put hero object in intent
            i.putExtra("intentKey", batman);
            //start activity with requestCodeForBatmanStats
            //identify it was started by clicking on batman
            startActivityForResult(i,requestCodeForBatmanStats);
        }
    });

        tvJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hero joker = new hero("Clown",55,77);
                Intent i = new Intent(MainActivity.this,HeroStatsActivity.class);
                //put hero object in intent
                i.putExtra("intentKey", joker);
                startActivityForResult(i,requestCodeForJokerStats);
            }
        });

}
    @Override
    protected void onActivityResult(int requestCode, int 				resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if(resultCode == RESULT_OK){
            if (data != null) {
                // Get data passed back from 2nd activity
                String like = data.getStringExtra("like");
                String statement = "";
                // If it is activity started by clicking 				//  Superman, create corresponding String
                if(requestCode == requestCodeForBatmanStats){
                    statement = "You " + like + " Batman";
                }
                // If 2nd activity started by clicking
                //  Batman, create a corresponding String
                if(requestCode == requestCodeForJokerStats){
                    statement = "You " + like + " Joker";
                }

                Toast.makeText(MainActivity.this, statement,
                        Toast.LENGTH_LONG).show();
            }
        }
    }

}
