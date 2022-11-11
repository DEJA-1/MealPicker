package com.example.mealpicker.adapter.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
    }

    override fun getItemCount() = filteredLunchList.size

}