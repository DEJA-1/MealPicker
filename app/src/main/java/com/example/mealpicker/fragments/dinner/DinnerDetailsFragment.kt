package com.example.mealpicker.fragments.dinner

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mealpicker.R
import com.example.mealpicker.adapter.details.SuggestedDinnerAdapter
import com.example.mealpicker.data.Datasource
import com.example.mealpicker.databinding.FragmentDinnerDetailsBinding

class DinnerDetailsFragment : Fragment() {

    private var _binding: FragmentDinnerDetailsBinding? = null
    private val binding get() = _binding!!

    private var mDinnerImageResourceId: Int = 0
    private var mDinnerStringResourceId: Int = 0
    private var mKcal: Int = 0
    private var mCarbs: Int = 0
    private var mFats: Int = 0
    private var mProtein: Int = 0

    private var mrDinnerImageResourceId: Int = 0
    private var mrDinnerStringResourceId: Int = 0
    private var mrKcal: Int = 0
    private var mrCarbs: Int = 0
    private var mrFats: Int = 0
    private var mrProtein: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { arguments?.let {
        mDinnerImageResourceId = it.getInt("dinnerImageResourceId")
        mDinnerStringResourceId = it.getInt("dinnerStringResourceId")
        mKcal = it.getInt("dKcal")
        mCarbs = it.getInt("dCarbs")
        mFats = it.getInt("dFats")
        mProtein = it.getInt("dProtein")

        mrDinnerImageResourceId = it.getInt("randomDinnerImageResourceId")
        mrDinnerStringResourceId = it.getInt("randomDinnerStringResourceId")
        mrKcal = it.getInt("rdKcal")
        mrCarbs = it.getInt("rdCarbs")
        mrFats = it.getInt("rdFats")
        mrProtein = it.getInt("rdProtein")

    }
        _binding = FragmentDinnerDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (mDinnerImageResourceId == 0)
            updateUIWithRandomDinner()
        else
            updateUI()
    }

    @SuppressLint("SetTextI18n")
    private fun updateUI() {
        binding.dinnerDetailsMealImage.setImageResource(mDinnerImageResourceId)
        binding.dinnerDetailsMealTitle.text = context?.getText(mDinnerStringResourceId)
        binding.dinnerDetailsKcalText.text = "Kcal: $mKcal"
        binding.dinnerDetailsCarbsText.text = "C: $mCarbs"
        binding.dinnerDetailsFatsText.text = "F: $mFats"
        binding.dinnerDetailsProteinText.text = "P: $mProtein"
    }

    private fun updateUIWithRandomDinner() {
        binding.dinnerDetailsMealImage.setImageResource(mrDinnerImageResourceId)
        binding.dinnerDetailsMealTitle.text = context?.getText(mrDinnerStringResourceId)
        binding.dinnerDetailsKcalText.text = "Kcal: $mrKcal"
        binding.dinnerDetailsCarbsText.text = "C: $mrCarbs"
        binding.dinnerDetailsFatsText.text = "F: $mrFats"
        binding.dinnerDetailsProteinText.text = "P: $mrProtein"
    }
}