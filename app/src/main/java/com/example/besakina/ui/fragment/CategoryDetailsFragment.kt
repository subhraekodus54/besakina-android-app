package com.example.besakina.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.denzcoskun.imageslider.models.SlideModel
import com.example.besakina.R
import com.example.besakina.adapter.AllAdsAdapter
import com.example.besakina.databinding.FragmentCategoriesBinding
import com.example.besakina.databinding.FragmentCategoryDetailsBinding
import com.example.besakina.model.AddsModel

class CategoryDetailsFragment : Fragment() {
    private var _binding: FragmentCategoryDetailsBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryDetailsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel("https://images.unsplash.com/photo-1511919884226-fd3cad34687c?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))
        imageList.add(SlideModel("https://images.unsplash.com/photo-1502877338535-766e1452684a?q=80&w=1472&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))
        imageList.add(SlideModel("https://images.unsplash.com/photo-1486406146926-c627a92ad1ab?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))
        binding.imageSlider.setImageList(imageList)

        binding.backArrow.setOnClickListener {
            findNavController().navigateUp()
        }

        val allAds: ArrayList<AddsModel> = ArrayList()
        allAds.add(AddsModel("https://images.unsplash.com/photo-1502877338535-766e1452684a?q=80&w=1472&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "₹ 1,40,000",
            "Dispur, Guwahati",
            "Today",
            "Hyundai 120, 2013 model"))
        allAds.add(AddsModel("https://images.unsplash.com/photo-1494976388531-d1058494cdd8?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "₹ 40,000",
            "Narengi, Guwahati",
            "Today",
            "Honda Amaze (2016)"))
        allAds.add(AddsModel("https://images.unsplash.com/photo-1502672260266-1c1ef2d93688?q=80&w=1380&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "₹ 13,00,000",
            "Bhetapara, Guwahati",
            "Yesterday",
            "1 BDS - 1 BA - 1010 Ft square luxurious apartment for sale."))
        allAds.add(AddsModel("https://images.unsplash.com/photo-1502877338535-766e1452684a?q=80&w=1472&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "₹ 1,40,000",
            "Dispur, Guwahati",
            "Today",
            "Hyundai 120, 2013 model"))
        allAds.add(AddsModel("https://images.unsplash.com/photo-1494976388531-d1058494cdd8?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "₹ 40,000",
            "Narengi, Guwahati",
            "Today",
            "Honda Amaze (2016)"))
        allAds.add(AddsModel("https://images.unsplash.com/photo-1502672260266-1c1ef2d93688?q=80&w=1380&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "₹ 13,00,000",
            "Bhetapara, Guwahati",
            "Yesterday",
            "1 BDS - 1 BA - 1010 Ft square luxurious apartment for sale."))
        initAllAdsRecyclerView(allAds)
    }

    private fun initAllAdsRecyclerView(list: List<AddsModel>){
        val mLayoutManager = GridLayoutManager(requireActivity(), 2)
        binding.allAdsRecycler.apply {
            layoutManager = mLayoutManager
            adapter = AllAdsAdapter(list, requireActivity())
        }
    }
}