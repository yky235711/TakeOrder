package com.yky.takeorder;

import android.app.ActivityGroup;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.TabActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class MainMenu extends ActivityGroup {
    public int quantity = 1;
    public String selectedPrefix="";
    public String selectedItem="";
    public static List<String> selectedSuffixList = new ArrayList<>();
    public List<String> prefix = new ArrayList<>(Arrays.asList(
            "Mongolian", "Hahn Premium Light", "Tooheys New", "Tooheys Old", "XXXX Gold", "VB", "Tooheys Extra Dry", "Crown Lager", "Anchor Steam", "Heineken", "Corona"
    ));
    public List<String> item = new ArrayList<>(Arrays.asList(
            "Beef", "Chicken", "KingPrawn", "Lamb", "Pork", "Duck", "Squid", "Crown Lager", "Anchor Steam", "Heineken", "Corona"
    ));

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        selectedSuffixList = new ArrayList<>();
        ArrayAdapter<String> prefixAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, prefix) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                /// Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                // Set the text size 25 dip for ListView each item
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);
                // Return the view
                return view;
            }

        };

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, item) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                /// Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                // Set the text size 25 dip for ListView each item
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);
                // Return the view
                return view;
            }

        };


        ListView prefixView = (ListView) findViewById(R.id.prefix);

        prefixView.setAdapter(prefixAdapter);
        prefixView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        prefixView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedPrefix = prefix.get(i);

            }

        });

        ListView itemView = (ListView) findViewById(R.id.item);

        itemView.setAdapter(itemsAdapter);
        itemView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        itemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //SharedPreferences sp = getSharedPreferences("prefix", MODE_PRIVATE);
                selectedItem = item.get(i);

            }

        });

        TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup(getLocalActivityManager());

        TabHost.TabSpec tab1 = tabHost.newTabSpec("Tab1");
        TabHost.TabSpec tab2 = tabHost.newTabSpec("Tab2");
        tab1.setIndicator("Tab1");
        //tab1.setContent(R.id.activity_suffix_tab1);
        tab1.setContent(new Intent(this, SuffixTab1Activity.class));
        tab2.setIndicator("Tab2");
        tab2.setContent(new Intent(this, SuffixTab2Activity.class));

        /** Add the tabs  to the TabHost to display. */
        tabHost.addTab(tab1);
        tabHost.addTab(tab2);

    }

    public void submitOk(View view) {
        String selectedSuffix = "";
        for (int i = 0; i < selectedSuffixList.size(); i++) {
            selectedSuffix += "+"+selectedSuffixList.get(i) + " ";
        }
        String q = "  x" + quantity;
        String thisOrder = selectedPrefix +" "+ selectedItem + selectedSuffix + q + "\n";
        Intent mainIntent = new Intent(this, FoodActivity.class);
        if(!selectedItem.isEmpty()){
            SharedPreferences prefs = getSharedPreferences("food_order", MODE_PRIVATE);
            String order = prefs.getString("food_order", "");
            SharedPreferences.Editor editor = getSharedPreferences("food_order", MODE_PRIVATE).edit();
            editor.putString("food_order", order + thisOrder);
            editor.commit();
        }

        // Start the new activity
        startActivity(mainIntent);
        finish();


    }

    public void display(int n, View view) {
        TextView quantityTextView = (TextView) view;
        quantityTextView.setText("" + n);
    }

    public void displayPrice(int n) {
        //TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        //priceTextView.setText("" + n);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        TextView countView = (TextView) findViewById(R.id.quantity_text_view);
        display(quantity, countView);
        //displayPrice(quantity*5);
    }

    public void decrement(View view) {
        quantity = quantity - 1;
        TextView countView = (TextView) findViewById(R.id.quantity_text_view);
        display(quantity, countView);
        //displayPrice(quantity*5);
    }

}
