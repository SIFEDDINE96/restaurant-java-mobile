package org.javaphile.restaurant;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.javaphile.restaurant.model.Meal;

import java.util.ArrayList;
import java.util.List;

public class MenuDetailsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MealAdapter mealAdapter;
    private List<Meal> mealList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_details);

        recyclerView = findViewById(R.id.recyclerViewMeals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get the selected category index from the Intent
        int categoryIndex = getIntent().getIntExtra("categoryIndex", -1);

        // Populate meal data based on the category index
        mealList = getMealsForCategoryIndex(categoryIndex);

        // Initialize the adapter with filtered meals and set it to RecyclerView
        mealAdapter = new MealAdapter(mealList);
        recyclerView.setAdapter(mealAdapter);
    }

    private List<Meal> getMealsForCategoryIndex(int categoryIndex) {
        List<Meal> meals = new ArrayList<>();

        switch (categoryIndex) {
            case 0: // Cuisine Orientale
                meals.add(new Meal("Falafel", "Crispy chickpea patties", 5.99));
                meals.add(new Meal("Hummus", "Creamy chickpea dip", 4.99));
                meals.add(new Meal("Shawarma", "Spiced meat wrap", 7.49));
                break;

            case 1: // Cuisine Marocaine
                meals.add(new Meal("Tagine", "Traditional Moroccan stew", 12.99));
                meals.add(new Meal("Couscous", "Steamed semolina with vegetables", 10.49));
                meals.add(new Meal("Pastilla", "Sweet and savory pie", 13.99));
                break;

            case 2: // Cuisine Asiatique
                meals.add(new Meal("Sushi", "Fresh sushi rolls", 12.99));
                meals.add(new Meal("Tempura", "Crispy fried vegetables", 9.99));
                meals.add(new Meal("Ramen", "Savory noodle soup", 8.49));
                break;

            case 3: // Cuisine Espagnole
                meals.add(new Meal("Paella", "Rice with seafood and vegetables", 14.99));
                meals.add(new Meal("Tapas", "Variety of Spanish appetizers", 11.99));
                meals.add(new Meal("Gazpacho", "Cold tomato soup", 6.99));
                break;

            default:
                meals.add(new Meal("Sample Meal", "Sample Description", 0.00));
                break;
        }

        return meals;
    }
}


