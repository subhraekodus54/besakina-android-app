package com.example.besakina.ui.fragment

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.besakina.R
import com.example.besakina.databinding.FragmentAccountBinding
import com.example.besakina.databinding.FragmentLoginBinding
import com.example.besakina.ui.activity.AuthActivity
import com.example.besakina.ui.activity.EditProfileActivity
import com.example.besakina.utils.PrefManager
import com.example.besakina.utils.isConnectedToInternet

class AccountFragment : Fragment() {
    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editBtn.setOnClickListener {
            val intent = Intent(requireActivity(), EditProfileActivity::class.java)
            startActivity(intent)
        }

        binding.logoutButton.setOnClickListener {
            showLogoutPopUp()
        }

        Glide.with(this)
            .load("https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?q=80&w=1480&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D") // image url
            .placeholder(R.color.light_grey) // any placeholder to load at start
            .centerCrop()
            .into(binding.profileImg)
    }

    private fun showLogoutPopUp(){
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Logout")
        builder.setMessage("Do you want to exit the app ?")
        builder.setIcon(R.drawable.baseline_logout_24)
        builder.setPositiveButton("Yes"){dialogInterface, which ->
            if(requireActivity().isConnectedToInternet()){
                PrefManager.clearPref()
                startActivity(Intent(requireActivity(), AuthActivity::class.java))
                requireActivity().finish()
            }else{
                Toast.makeText(requireActivity(),"No internet connection.", Toast.LENGTH_LONG).show()
            }
        }
        builder.setNegativeButton("No"){dialogInterface, which ->
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }
}