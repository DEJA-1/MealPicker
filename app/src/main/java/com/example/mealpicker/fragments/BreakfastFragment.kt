package com.example.mealpicker.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat
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
        val adapter = BreakfastAdapter(requireContext(), breakfastList, this)
        val recyclerView = binding.breakfastRecyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //random meal navigation
        binding.breakfastFab.setOnClickListener { onFabClicked(breakfastList) }

    }

    private fun onFabClicked(breakfastList: List<Breakfast>) {
        findNavController().navigate(R.id.action_breakfastFragment_to_DetailsFragment)
        val randomBreakfast = getRandomBreakfast(breakfastList)
        Toast.makeText(context, "Drawed: ${randomBreakfast.breakfastStringResourceId}", Toast.LENGTH_SHORT)
            .show()
    }

    fun getRandomBreakfast(breakfastList: List<Breakfast>): Breakfast {
        return breakfastList.random()
    }
}