package com.yky.takeorder;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodActivity extends Activity {

    public ArrayList<String> categorys=new ArrayList<>();
    public String order="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file

        setContentView(R.layout.activity_food);
        //get order_list
        SharedPreferences prefs = getSharedPreferences("food_order", MODE_PRIVATE);
        order = prefs.getString("food_order", "");
        TextView orderView = (TextView) findViewById(R.id.food_order);
        orderView.setText(order);



        TextView view1 = (TextView) findViewById(R.id.entree);

        // Set a click listener on that View
        view1.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link SoftDrinkActivity}
                Intent numbersIntent = new Intent(FoodActivity.this, MainMenu.class);

                // Start the new activity
                startActivity(numbersIntent);
                finish();


            }
        });


        TextView view3 = (TextView) findViewById(R.id.main);

        // Set a click listener on that View
        view3.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link RedActivity}
                Intent familyIntent = new Intent(FoodActivity.this, MainMenu.class);

                // Start the new activity
                startActivity(familyIntent);
                finish();

            }
        });


    }


    public void newOrder(View view){
        SharedPreferences.Editor editor = getSharedPreferences("food_order",MODE_PRIVATE).edit();
        editor.putString("food_order", "");
        editor.commit();
        TextView orderTextView = (TextView) findViewById(R.id.food_order);
        orderTextView.setText("");
    }
    public void undo(View view){
        String[] lines = order.split("\\n");
        String s="";
        for(int i=0;i<lines.length-1;i++){
            s+=lines[i]+"\n";
        }
        SharedPreferences.Editor editor = getSharedPreferences("food_order",MODE_PRIVATE).edit();
        editor.putString("order", s);
        editor.commit();
        TextView orderTextView = (TextView) findViewById(R.id.food_order);
        orderTextView.setText(s);
    }


}
