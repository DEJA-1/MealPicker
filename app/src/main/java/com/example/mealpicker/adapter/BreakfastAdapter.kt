package com.example.mealpicker.adapter

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
import com.example.mealpicker.fragments.breakfast.BreakfastDetailsFragment
import com.example.mealpicker.model.Breakfast

class BreakfastAdapter(
    val context: Context, private var breakfastList: List<Breakfast>) : RecyclerView.Adapter<BreakfastAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val breakfastTitle: TextView = itemView.findViewById(R.id.meal_title)
        val breakfastImage: ImageView = itemView.findViewById(R.id.meal_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.breakfast_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentBreakfast = breakfastList[position]
        holder.breakfastTitle.text = context.getText(currentBreakfast.breakfastStringResourceId)
        holder.breakfastImage.setImageResource(currentBreakfast.breakfastImageResourceId)

        holder.breakfastImage.setOnClickListener {

            val bundle = bundleOf(
                "breakfastImageResourceId" to currentBreakfast.breakfastImageResourceId,
                "breakfastStringResourceId" to currentBreakfast.breakfastStringResourceId,
                "bKcal" to currentBreakfast.kcal,
                "bCarbs" to currentBreakfast.carbs,
                "bFats" to currentBreakfast.fats,
                "bProtein" to currentBreakfast.protein
            )

            holder.itemView.findNavController()
                .navigate(R.id.action_breakfastFragment_to_BreakfastDetailsFragment, bundle)
        }
    }

    override fun getItemCount() = breakfastList.size

}