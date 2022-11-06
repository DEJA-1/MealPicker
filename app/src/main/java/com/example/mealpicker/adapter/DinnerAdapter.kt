package com.example.mealpicker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mealpicker.R
import com.example.mealpicker.model.Dinner

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
    }

    override fun getItemCount(): Int = dinnerList.size

}