package org.javaphile.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MenuCategoriesActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_categories);

        // Initialiser les catégories de cuisine
        String[] categories = {"Cuisine Orientale", "Cuisine Marocaine", "Cuisine Asiatique", "Cuisine Espagnole"};

        // Référence vers la ListView dans le layout
        ListView listView = findViewById(R.id.listViewCategories);

        // Créer un ArrayAdapter pour afficher les catégories
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categories);
        listView.setAdapter(adapter);

        // Gérer le clic sur les éléments de la liste
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Intent vers l'activité des détails du menu pour chaque catégorie
                Intent intent = new Intent(MenuCategoriesActivity.this, MenuDetailsActivity.class);
                intent.putExtra("category", categories[position]);
                startActivity(intent);
            }
        });
    }
}
