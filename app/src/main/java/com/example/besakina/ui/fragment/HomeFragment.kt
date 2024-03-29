package com.example.besakina.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.models.SlideModel
import com.example.besakina.R
import com.example.besakina.adapter.AllAdsAdapter
import com.example.besakina.adapter.FeaturedAdsAdapter
import com.example.besakina.adapter.HomeCategoriesAdapter
import com.example.besakina.databinding.FragmentHomeBinding
import com.example.besakina.model.AddsModel
import com.example.besakina.model.HomeCategoriesModel
import com.example.besakina.ui.activity.SearchActivity
import com.example.besakina.ui.activity.SetLocationActivity
import com.example.besakina.utils.ClickListener

class HomeFragment : Fragment(), ClickListener {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.consLayOne.setOnClickListener {
            val intent = Intent(requireActivity(), SearchActivity::class.java)
            startActivity(intent)
        }

        binding.locLay.setOnClickListener {
            val intent = Intent(requireActivity(), SetLocationActivity::class.java)
            startActivity(intent)
        }

        val listOne: ArrayList<HomeCategoriesModel> = ArrayList()
        listOne.add(HomeCategoriesModel("properties", "Properties"))
        listOne.add(HomeCategoriesModel("vehicle", "Vehicle"))
        listOne.add(HomeCategoriesModel("health_and_wellness", "Health"))
        listOne.add(HomeCategoriesModel("hospitality_travel_tourism", "Hospitality"))
        listOne.add(HomeCategoriesModel("education_learning", "Education"))
        initCategoriesRecyclerView(listOne)

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
        initFeatureAdsRecyclerView(featuredAds)


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

        //banner
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel("https://www.cyberclick.net/hs-fs/hubfs/20%20Creative%20and%20Powerful%20Facebook%20Ad%20Examples.jpg?width=850&name=20%20Creative%20and%20Powerful%20Facebook%20Ad%20Examples.jpg"))
        imageList.add(SlideModel("https://plus.unsplash.com/premium_photo-1676139292936-a2958a0d7177?q=80&w=1618&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"))
        imageList.add(SlideModel("https://www.cyberclick.net/hubfs/What%20Are%20Social%20Media%20Ads.jpg"))
        binding.imageSlider.setImageList(imageList)
    }

    private fun initCategoriesRecyclerView(list: List<HomeCategoriesModel>){
        val mLayoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.categoriesRecycler.apply {
            layoutManager = mLayoutManager
            adapter = HomeCategoriesAdapter(list,requireActivity(), this@HomeFragment)
        }
    }

    private fun initFeatureAdsRecyclerView(list: List<AddsModel>){
        val mLayoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.featuredAdsRecycler.apply {
            layoutManager = mLayoutManager
            adapter = FeaturedAdsAdapter(list,requireActivity())
        }
    }

    private fun initAllAdsRecyclerView(list: List<AddsModel>){
        val mLayoutManager = GridLayoutManager(requireActivity(), 2)
        binding.allAdsRecycler.apply {
            layoutManager = mLayoutManager
            adapter = AllAdsAdapter(list, requireActivity())
        }
    }

    override fun onClick(view: View, data: String?) {
        findNavController().navigate(R.id.action_homeFragment_to_categoryDetailsFragment)
    }
}