package com.example.mealpicker.fragments.lunch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mealpicker.R
import com.example.mealpicker.adapter.details.SuggestedDinnerAdapter
import com.example.mealpicker.data.Datasource
import com.example.mealpicker.databinding.FragmentBreakfastDetailsBinding
import com.example.mealpicker.databinding.FragmentLunchDetailsBinding

class LunchDetailsFragment : Fragment() {

    private var _binding: FragmentLunchDetailsBinding? = null
    private val binding get() = _binding!!

    private var mLunchImageResourceId: Int = 0
    private var mLunchStringResourceId: Int = 0
    private var mKcal: Int = 0
    private var mCarbs: Int = 0
    private var mFats: Int = 0
    private var mProtein: Int = 0

    private var mrLunchImageResourceId: Int = 0
    private var mrLunchStringResourceId: Int = 0
    private var mrKcal: Int = 0
    private var mrCarbs: Int = 0
    private var mrFats: Int = 0
    private var mrProtein: Int = 0

    private var dinnerList = Datasource().loadDinners()
    private var filteredDinnerList = dinnerList

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { arguments?.let {
        mLunchImageResourceId = it.getInt("lunchImageResourceId")
        mLunchStringResourceId = it.getInt("lunchStringResourceId")
        mKcal = it.getInt("lKcal")
        mCarbs = it.getInt("lCarbs")
        mFats = it.getInt("lFats")
        mProtein = it.getInt("lProtein")

        mrLunchImageResourceId = it.getInt("randomLunchImageResourceId")
        mrLunchStringResourceId = it.getInt("randomLunchStringResourceId")
        mrKcal = it.getInt("rlKcal")
        mrCarbs = it.getInt("rlCarbs")
        mrFats = it.getInt("rlFats")
        mrProtein = it.getInt("rlProtein")
    }
        _binding = FragmentLunchDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //recyclerView
        val adapter = SuggestedDinnerAdapter(filteredDinnerList)
        val recyclerView = binding.lunchDetailsRecyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        if (mLunchImageResourceId == 0)
            updateUIWithRandomLunch()
        else
            updateUI()
    }

    private fun updateUI() {
        binding.lunchDetailsMealImage.setImageResource(mLunchImageResourceId)
        binding.lunchDetailsMealTitle.text = context?.getText(mLunchStringResourceId)
        binding.lunchDetailsKcalText.text = "Kcal: $mKcal"
        binding.lunchDetailsCarbsText.text = "C: $mCarbs"
        binding.lunchDetailsFatsText.text = "F: $mFats"
        binding.lunchDetailsProteinText.text = "P: $mProtein"
    }

    private fun updateUIWithRandomLunch() {
        binding.lunchDetailsMealImage.setImageResource(mrLunchImageResourceId)
        binding.lunchDetailsMealTitle.text = context?.getText(mrLunchStringResourceId)
        binding.lunchDetailsKcalText.text = "Kcal: $mrKcal"
        binding.lunchDetailsCarbsText.text = "C: $mrCarbs"
        binding.lunchDetailsFatsText.text = "F: $mrFats"
        binding.lunchDetailsProteinText.text = "P: $mrProtein"
    }


}