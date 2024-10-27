package org.javaphile.restaurant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.javaphile.restaurant.model.Meal;

import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealViewHolder> {
    private List<Meal> mealList;

    public MealAdapter(List<Meal> mealList) {
        this.mealList = mealList;
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meal, parent, false);
        return new MealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        Meal meal = mealList.get(position);
        holder.nameTextView.setText(meal.getName());
        holder.descriptionTextView.setText(meal.getDescription());
        holder.priceTextView.setText("$" + meal.getPrice());
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    class MealViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, descriptionTextView, priceTextView;

        MealViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.textMealName);
            descriptionTextView = itemView.findViewById(R.id.textMealDescription);
            priceTextView = itemView.findViewById(R.id.textMealPrice);
        }
    }
}
