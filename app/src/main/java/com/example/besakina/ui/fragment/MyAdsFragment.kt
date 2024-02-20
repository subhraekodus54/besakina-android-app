package com.example.besakina.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.besakina.R
import com.example.besakina.adapter.FeaturedAdsAdapter
import com.example.besakina.adapter.MyAdsAdapter
import com.example.besakina.databinding.FragmentLoginBinding
import com.example.besakina.databinding.FragmentMyAdsBinding
import com.example.besakina.model.AddsModel

class MyAdsFragment : Fragment() {
    private var _binding: FragmentMyAdsBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyAdsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val featuredAds: ArrayList<AddsModel> = ArrayList()
        featuredAds.add(AddsModel("https://images.unsplash.com/photo-1502877338535-766e1452684a?q=80&w=1472&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "₹ 1,40,000",
            "Dispur, Guwahati",
            "Today",
            "Hyundai 120, 2013 model"))
        featuredAds.add(AddsModel("https://images.unsplash.com/photo-1494976388531-d1058494cdd8?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "₹ 40,000",
            "Narengi, Guwahati",
            "Today",
            "Honda Amaze (2016)"))
        featuredAds.add(AddsModel("https://images.unsplash.com/photo-1502672260266-1c1ef2d93688?q=80&w=1380&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "₹ 13,00,000",
            "Bhetapara, Guwahati",
            "Yesterday",
            "1 BDS - 1 BA - 1010 Ft square luxurious apartment for sale."))
        featuredAds.add(AddsModel("https://images.unsplash.com/photo-1502877338535-766e1452684a?q=80&w=1472&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "₹ 1,40,000",
            "Dispur, Guwahati",
            "Today",
            "Hyundai 120, 2013 model"))
        initRecyclerView(featuredAds)
    }

    private fun initRecyclerView(list: List<AddsModel>){
        val mLayoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.myAdsRecycler.apply {
            layoutManager = mLayoutManager
            adapter = MyAdsAdapter(list,requireActivity())
        }
    }
}