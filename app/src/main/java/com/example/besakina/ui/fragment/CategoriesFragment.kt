package com.example.besakina.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.besakina.R
import com.example.besakina.adapter.AllAdsAdapter
import com.example.besakina.adapter.HomeCategoriesAdapter
import com.example.besakina.databinding.FragmentCategoriesBinding
import com.example.besakina.databinding.FragmentLoginOtpBinding
import com.example.besakina.model.AddsModel
import com.example.besakina.model.HomeCategoriesModel
import com.example.besakina.utils.ClickListener

class CategoriesFragment : Fragment(), ClickListener {
    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listOne: ArrayList<HomeCategoriesModel> = ArrayList()
        listOne.add(HomeCategoriesModel("properties", "Properties"))
        listOne.add(HomeCategoriesModel("vehicle", "Vehicle"))
        listOne.add(HomeCategoriesModel("health_and_wellness", "Health"))
        listOne.add(HomeCategoriesModel("hospitality_travel_tourism", "Hospitality"))
        listOne.add(HomeCategoriesModel("education_learning", "Education"))
        initCategoriesRecyclerView(listOne)
    }

    private fun initCategoriesRecyclerView(list: List<HomeCategoriesModel>){
        val mLayoutManager = GridLayoutManager(requireActivity(), 3)
        binding.categoriesRecycler.apply {
            layoutManager = mLayoutManager
            adapter = HomeCategoriesAdapter(list,requireActivity(), this@CategoriesFragment)
        }
    }

    override fun onClick(view: View, data: String?) {
        findNavController().navigate(R.id.action_categoriesFragment_to_categoryDetailsFragment)
    }
}