package com.example.mealpicker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mealpicker.adapter.BreakfastAdapter
import com.example.mealpicker.databinding.FragmentDetailsBinding
import com.example.mealpicker.model.Breakfast

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private var mBreakfastStringResourceId: Int = 0
    private var mBreakfastImageResourceId: Int = 0
    private var mKcal: Int = 0
    private var mCarbs: Int = 0
    private var mFats: Int = 0
    private var mProtein: Int = 0


    val breakfastFragment = BreakfastFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let {
            mBreakfastImageResourceId = it.getInt("breakfastImageResourceId")
            mBreakfastStringResourceId = it.getInt("breakfastStringResourceId")
            mKcal = it.getInt("kcal")
            mCarbs = it.getInt("carbs")
            mFats = it.getInt("fats")
            mProtein = it.getInt("protein")
        }

        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateUI()
    }

    private fun updateUI() {
        binding.detailsMealImage.setImageResource(mBreakfastImageResourceId)
        binding.detailsMealTitle.text = context?.getText(mBreakfastStringResourceId)
        binding.detailsKcalText.text = "Kcal: ${mKcal.toString()}"
        binding.detailsCarbsText.text = "C: ${mCarbs.toString()}"
        binding.detailsFatsText.text = "F: ${mFats.toString()}"
        binding.detailsProteinText.text = "P: ${mProtein.toString()}"
    }
}