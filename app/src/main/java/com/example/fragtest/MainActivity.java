package com.example.fragtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> plots = new ArrayList<>();
        plots.add("Horonesde");
        plots.add("Slonorovbe");
        plots.add("Berengve");
        plots.add("Otrega");
        plots.add("Fantinoza");
        plots.add("Notiden Gosto");
        plots.add("Wondyowgzo");
        plots.add("Obvewes");

        listView = (ListView) findViewById(R.id.listview);

        ArrayAdapter listAdapter = new ArrayAdapter(
                this, android.R.layout.simple_list_item_1, plots);
        listView.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Bundle bundle = new Bundle();
                bundle.putString("pressed", plots.get(position));

                BlankFragment blankFragment = new BlankFragment();
                blankFragment.setArguments(bundle);

                getSupportFragmentManager().beginTransaction().replace(R.id.frame,blankFragment).commit();

//                fragmentTransaction.add(R.id.frame,blankFragment);
//                fragmentTransaction.commit();
            }
        };
        listView.setOnItemClickListener(itemClickListener);
    }
}