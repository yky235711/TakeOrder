package com.yky.takeorder;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SuffixTab1Activity extends Activity {


    public List<String> suffix=new ArrayList<>(Arrays.asList(
            "SizPlate","Chilli","Cashew","Vegetable"
    ));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suffix_tab1);
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, suffix){
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

        ListView tabView = (ListView) findViewById(R.id.activity_suffix_tab1);

        tabView.setAdapter(itemsAdapter);
        tabView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        tabView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String addSuffix=suffix.get(i);
                if(MainMenu.selectedSuffixList.contains(addSuffix)){
                    MainMenu.selectedSuffixList.remove(addSuffix);
                }else{
                    MainMenu.selectedSuffixList.add(addSuffix);
                }

            }

        });

    }



}
