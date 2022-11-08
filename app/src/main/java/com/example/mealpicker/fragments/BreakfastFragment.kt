package com.example.mealpicker.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        val breakfastList = Datasource().loadBreakfasts()
        val adapter = BreakfastAdapter(requireContext(), breakfastList)
        val recyclerView = binding.breakfastRecyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //fab button
        binding.fabBreakfast.setOnClickListener { manageRandomBreakfast(breakfastList) }

    }

    private fun manageRandomBreakfast(breakfastList : List<Breakfast>) {
        drawBreakfast(breakfastList)
//        findNavController().navigate(R.id.)
    }

    private fun drawBreakfast(breakfastList: List<Breakfast>) : Breakfast {
        return breakfastList.random()
    }

}