package com.yky.takeorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file

        setContentView(R.layout.activity_main);

        ImageView foodView = (ImageView) findViewById(R.id.food_image);

        // Set a click listener on that View
        foodView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link SoftDrinkActivity}
                Intent myIntent = new Intent(MainActivity.this, FoodActivity.class);

                // Start the new activity
                startActivity(myIntent);

            }
        });

        ImageView drinkView = (ImageView) findViewById(R.id.drink_image);

        // Set a click listener on that View
        drinkView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link SoftDrinkActivity}
                Intent myIntent = new Intent(MainActivity.this, DrinkActivity.class);

                // Start the new activity
                startActivity(myIntent);

            }
        });
    }

}

