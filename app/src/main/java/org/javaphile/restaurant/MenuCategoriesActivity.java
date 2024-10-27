package org.javaphile.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MenuCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_categories);

        String[] categories = {"Cuisine Orientale", "Cuisine Marocaine", "Cuisine Asiatique", "Cuisine Espagnole"};

        ListView listView = findViewById(R.id.listViewCategories);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categories);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MenuCategoriesActivity.this, MenuDetailsActivity.class);
                intent.putExtra("categoryIndex", position);
                startActivity(intent);
            }
        });
    }
}

