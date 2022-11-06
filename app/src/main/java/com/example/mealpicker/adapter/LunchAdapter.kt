package com.example.mealpicker.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
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

        holder.lunchImage.setOnClickListener { showDetails(currentLunch) }
    }

    override fun getItemCount(): Int = lunchList.size

    private fun showDetails(currentLunch: Lunch) {
        val builder = AlertDialog.Builder(context)

        builder.setNeutralButton("Ok") { _, _ -> }
        builder.setTitle("Details: ")
        builder.setMessage("Kcal: ${currentLunch.kcal}\nCarbs: ${currentLunch.carbs}\nFat: ${currentLunch.fats} \nProtein: ${currentLunch.protein}")
        builder.create().show()
    }

}