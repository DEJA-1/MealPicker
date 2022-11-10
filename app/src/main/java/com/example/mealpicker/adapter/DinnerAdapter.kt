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
import com.example.mealpicker.model.Dinner
import com.example.mealpicker.model.Lunch

class DinnerAdapter(val context: Context, private var dinnerList: List<Dinner>) : RecyclerView.Adapter<DinnerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dinnerTitle: TextView = itemView.findViewById(R.id.meal_title)
        val dinnerImage: ImageView = itemView.findViewById(R.id.meal_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dinner_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentDinner = dinnerList[position]

        holder.dinnerTitle.text = context.resources.getString(currentDinner.dinnerStringResourceId)
        holder.dinnerImage.setImageResource(currentDinner.dinnerImageResourceId)
        holder.dinnerImage.setOnClickListener {

            val bundle = bundleOf(
                "dinnerImageResourceId" to currentDinner.dinnerImageResourceId,
                "dinnerStringResourceId" to currentDinner.dinnerStringResourceId,
                "dKcal" to currentDinner.kcal,
                "dCarbs" to currentDinner.carbs,
                "dFats" to currentDinner.fats,
                "dProtein" to currentDinner.protein
            )

            holder.itemView.findNavController().navigate(R.id.action_dinnerFragment_to_dinnerDetailsFragment, bundle)
        }
    }

    override fun getItemCount(): Int = dinnerList.size

}