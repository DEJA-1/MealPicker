package com.example.mealpicker.adapter.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.mealpicker.R
import com.example.mealpicker.model.Lunch

class SuggestedLunchAdapter(private val filteredLunchList: List<Lunch>) :
    RecyclerView.Adapter<SuggestedLunchAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val suggestedMealImage: ImageView = itemView.findViewById(R.id.suggested_meal_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.suggested_meal_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentSuggestedLunch = filteredLunchList[position]

        holder.suggestedMealImage.setImageResource(currentSuggestedLunch.lunchImageResourceId)

        holder.suggestedMealImage.setOnClickListener {
            val bundle = bundleOf(
                "lunchImageResourceId" to currentSuggestedLunch.lunchImageResourceId,
                "lunchStringResourceId" to currentSuggestedLunch.lunchStringResourceId,
                "lKcal" to currentSuggestedLunch.kcal,
                "lCarbs" to currentSuggestedLunch.carbs,
                "lFats" to currentSuggestedLunch.fats,
                "lProtein" to currentSuggestedLunch.protein
            )

            holder.itemView.findNavController().navigate(R.id.action_BreakfastDetailsFragment_to_lunchDetailsFragment, bundle)
        }
    }

    override fun getItemCount() = filteredLunchList.size

}