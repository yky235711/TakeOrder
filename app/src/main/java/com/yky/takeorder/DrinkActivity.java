package com.yky.takeorder;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class DrinkActivity extends Activity {

    public ArrayList<String> categorys=new ArrayList<>();
    //public ArrayList<String> orders=new ArrayList<>();
    public String myorder="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file

        setContentView(R.layout.activity_drink);
        //get order_list
        SharedPreferences prefs = getSharedPreferences("order_list", MODE_PRIVATE);
        myorder = prefs.getString("order", "");
        TextView order = (TextView) findViewById(R.id.order);
        order.setText(myorder);



        TextView numbers = (TextView) findViewById(R.id.soft);

        // Set a click listener on that View
        numbers.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link SoftDrinkActivity}
                Intent numbersIntent = new Intent(DrinkActivity.this, SoftDrinkMenu.class);

                // Start the new activity
                startActivity(numbersIntent);
                finish();


            }
        });

        // Find the View that shows the family category
        TextView family = (TextView) findViewById(R.id.red);

        // Set a click listener on that View
        family.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link RedActivity}
                Intent familyIntent = new Intent(DrinkActivity.this, RedMenu.class);

                // Start the new activity
                startActivity(familyIntent);
                finish();

            }
        });

        // Find the View that shows the colors category
        TextView colors = (TextView) findViewById(R.id.white);

        // Set a click listener on that View
        colors.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the colors category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link WhiteActivity}
                Intent colorsIntent = new Intent(DrinkActivity.this, WhiteMenu.class);

                // Start the new activity
                startActivity(colorsIntent);
                finish();
            }
        });

        TextView smallView = (TextView) findViewById(R.id.small);

        // Set a click listener on that View
        smallView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the phrases category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link SmallActivity}
                Intent smallIntent = new Intent(DrinkActivity.this, SmallMenu.class);

                // Start the new activity
                startActivity(smallIntent);
                finish();
            }
        });
        TextView spiritsView = (TextView) findViewById(R.id.spirits);

        // Set a click listener on that View
        spiritsView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the phrases category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link SmallActivity}
                Intent spiritsIntent = new Intent(DrinkActivity.this, SpiritsMenu.class);

                // Start the new activity
                startActivity(spiritsIntent);
                finish();
            }
        });
        TextView beerView = (TextView) findViewById(R.id.beer);
        beerView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the phrases category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link SmallActivity}
                Intent beerIntent = new Intent(DrinkActivity.this, BeerMenu.class);

                // Start the new activity
                startActivity(beerIntent);
                finish();
            }
        });

    }


    public void newOrder(View view){
        SharedPreferences.Editor editor = getSharedPreferences("order_list",MODE_PRIVATE).edit();
        editor.putString("order", "");
        editor.commit();
        TextView orderTextView = (TextView) findViewById(R.id.order);
        orderTextView.setText("");
    }
    public void undo(View view){
        String[] lines = myorder.split("\\n");
        String s="";
        for(int i=0;i<lines.length-1;i++){
            s+=lines[i]+"\n";
        }
        SharedPreferences.Editor editor = getSharedPreferences("order_list",MODE_PRIVATE).edit();
        editor.putString("order", s);
        editor.commit();
        TextView orderTextView = (TextView) findViewById(R.id.order);
        orderTextView.setText(s);
    }

    //openMenu not working
    public void openMenu(View view){
        TextView newView = (TextView) view;

        // Set a click listener on that View
        newView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the phrases category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link SmallActivity}
                Intent mainIntent = new Intent(DrinkActivity.this, view.getClass());

                // Start the new activity
                startActivity(mainIntent);
            }
        });
    }

}
