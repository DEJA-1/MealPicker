package com.example.mealpicker.fragments.breakfast

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mealpicker.adapter.details.SuggestedLunchAdapter
import com.example.mealpicker.data.Datasource
import com.example.mealpicker.databinding.FragmentBreakfastDetailsBinding

class BreakfastDetailsFragment : Fragment() {

    private var _binding: FragmentBreakfastDetailsBinding? = null
    private val binding get() = _binding!!

    private var mBreakfastStringResourceId: Int = 0
    private var mBreakfastImageResourceId: Int = 0
    private var mKcal: Int = 0
    private var mCarbs: Int = 0
    private var mFats: Int = 0
    private var mProtein: Int = 0

    private var mrBreakfastStringResourceId: Int = 0
    private var mrBreakfastImageResourceId: Int = 0
    private var mrKcal: Int = 0
    private var mrCarbs: Int = 0
    private var mrFats: Int = 0
    private var mrProtein: Int = 0

    private var lunchList = Datasource().loadLunches()
    var filteredLunchList = lunchList


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let {
            mBreakfastImageResourceId = it.getInt("breakfastImageResourceId")
            mBreakfastStringResourceId = it.getInt("breakfastStringResourceId")
            mKcal = it.getInt("bKcal")
            mCarbs = it.getInt("bCarbs")
            mFats = it.getInt("bFats")
            mProtein = it.getInt("bProtein")

            //random breakfast
            mrBreakfastImageResourceId = it.getInt("randomBreakfastImageResourceId")
            mrBreakfastStringResourceId = it.getInt("randomBreakfastStringResourceId")
            mrKcal = it.getInt("rbKcal")
            mrCarbs = it.getInt("rbCarbs")
            mrFats = it.getInt("rbFats")
            mrProtein = it.getInt("rbProtein")
        }

        _binding = FragmentBreakfastDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //recyclerView

        //TODO - suggestion system based on meal's macros
        filteredLunchList = if (mKcal <= 300) {
            lunchList.filter { it.kcal <= 600 }
        } else {
            lunchList.filter { it.kcal <= 400 }
        }

        val adapter = SuggestedLunchAdapter(filteredLunchList)
        val recyclerView = binding.breakfastDetailsRecyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        if (mBreakfastImageResourceId == 0)
            updateUIWithRandomBreakfast()
        else
            updateUI()
    }

    @SuppressLint("SetTextI18n")
    private fun updateUI() {
        binding.breakfastDetailsMealImage.setImageResource(mBreakfastImageResourceId)
        binding.breakfastDetailsMealTitle.text = context?.getText(mBreakfastStringResourceId)
        binding.breakfastDetailsKcalText.text = "Kcal: $mKcal"
        binding.breakfastDetailsCarbsText.text = "C: $mCarbs"
        binding.breakfastDetailsFatsText.text = "F: $mFats"
        binding.breakfastDetailsProteinText.text = "P: $mProtein"
    }

    private fun updateUIWithRandomBreakfast() {
        binding.breakfastDetailsMealImage.setImageResource(mrBreakfastImageResourceId)
        binding.breakfastDetailsMealTitle.text = context?.getText(mrBreakfastStringResourceId)
        binding.breakfastDetailsKcalText.text = "Kcal: $mrKcal"
        binding.breakfastDetailsCarbsText.text = "C: $mrCarbs"
        binding.breakfastDetailsFatsText.text = "F: $mrFats"
        binding.breakfastDetailsProteinText.text = "P: $mrProtein"
    }
}