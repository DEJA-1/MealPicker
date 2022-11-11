package com.example.mealpicker.fragments.breakfast

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealpicker.R
import com.example.mealpicker.adapter.BreakfastAdapter
import com.example.mealpicker.data.Datasource
import com.example.mealpicker.databinding.FragmentBreakfastBinding
import com.example.mealpicker.model.Breakfast

class BreakfastFragment : Fragment() {

    private var _binding: FragmentBreakfastBinding? = null
    private val binding get() = _binding!!

    private val breakfastList = Datasource().loadBreakfasts()
    val randomBreakfast = getRandomBreakfast(breakfastList)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentBreakfastBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //recyclerView
        val breakfastList = breakfastList
        val adapter = BreakfastAdapter(requireContext(), breakfastList)
        val recyclerView = binding.breakfastRecyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //random meal navigation
        binding.breakfastFab.setOnClickListener { onFabClicked(breakfastList) }

    }

    private fun onFabClicked(breakfastList: List<Breakfast>) {
        val randomBreakfast = getRandomBreakfast(breakfastList)

        val bundle = bundleOf(
            "randomBreakfastImageResourceId" to randomBreakfast.breakfastImageResourceId,
            "randomBreakfastStringResourceId" to randomBreakfast.breakfastStringResourceId,
            "rbKcal" to randomBreakfast.kcal,
            "rbCarbs" to randomBreakfast.carbs,
            "rbFats" to randomBreakfast.fats,
            "rbProtein" to randomBreakfast.protein
        )

        findNavController().navigate(R.id.action_breakfastFragment_to_BreakfastDetailsFragment, bundle)

    }

   private fun getRandomBreakfast(breakfastList: List<Breakfast>): Breakfast {
        return breakfastList.random()
    }
}