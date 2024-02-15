package com.example.besakina.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.besakina.MainActivity
import com.example.besakina.R
import com.example.besakina.databinding.FragmentLoginBinding
import com.example.besakina.databinding.FragmentLoginOtpBinding
import com.example.besakina.ui.activity.AuthActivity
import com.example.besakina.ui.activity.SetLocationActivity

class LoginOtpFragment : Fragment() {
    private var _binding: FragmentLoginOtpBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginOtpBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.verifyBtn.setOnClickListener {
            val intent = Intent(requireActivity(), SetLocationActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }
}