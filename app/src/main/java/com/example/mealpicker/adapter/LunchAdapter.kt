package com.example.mealpicker.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mealpicker.R
import com.example.mealpicker.model.Breakfast
import com.example.mealpicker.model.Lunch

class LunchAdapter(val context: Context, private var lunchList: List<Lunch>) : RecyclerView.Adapter<LunchAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val lunchTitle: TextView = itemView.findViewById(R.id.meal_title)
        val lunchImage: ImageView = itemView.findViewById(R.id.meal_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lunch_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentLunch = lunchList[position]

        holder.lunchTitle.text = context.getText(currentLunch.lunchStringResourceId)
        holder.lunchImage.setImageResource(currentLunch.lunchImageResourceId)

        holder.lunchImage.setOnClickListener {

            val bundle = bundleOf(
                "lunchImageResourceId" to currentLunch.lunchImageResourceId,
                "lunchStringResourceId" to currentLunch.lunchStringResourceId,
                "lKcal" to currentLunch.kcal,
                "lCarbs" to currentLunch.carbs,
                "lFats" to currentLunch.fats,
                "lProtein" to currentLunch.protein
            )

            holder.itemView.findNavController().navigate(R.id.action_lunchFragment_to_lunchDetailsFragment, bundle)
        }
    }

    override fun getItemCount(): Int = lunchList.size


}