package com.example.mealpicker.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mealpicker.R
import com.example.mealpicker.data.Datasource
import com.example.mealpicker.fragments.BreakfastFragment
import com.example.mealpicker.model.Breakfast

class BreakfastAdapter(val context: Context, private var breakfastList: List<Breakfast>) :
    RecyclerView.Adapter<BreakfastAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val breakfastTitle: TextView = itemView.findViewById(R.id.meal_title)
        val breakfastImage: ImageView = itemView.findViewById(R.id.meal_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.meal_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentBreakfast = breakfastList[position]
        holder.breakfastTitle.text = context.getText(currentBreakfast.breakfastStringResourceId)
        holder.breakfastImage.setImageResource(currentBreakfast.breakfastImageResourceId)

        holder.breakfastImage.setOnClickListener {
            showDetails(currentBreakfast)
        }
    }

    override fun getItemCount() = breakfastList.size

    fun showDetails(currentBreakfast: Breakfast) {
        val builder = AlertDialog.Builder(context)

        builder.setNeutralButton("Ok") { _, _ -> }
        builder.setTitle("Details: ")
        builder.setMessage("Kcal: ${currentBreakfast.kcal}\nCarbs: ${currentBreakfast.carbs}\nFat: ${currentBreakfast.fats} \nProtein: ${currentBreakfast.protein}")
        builder.create().show()
    }

}