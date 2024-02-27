package com.example.besakina.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.besakina.R
import com.example.besakina.databinding.FragmentLoginBinding
import com.example.besakina.model.repository.Outcome
import com.example.besakina.utils.isConnectedToInternet
import com.example.besakina.utils.loadingDialog
import com.example.besakina.utils.showKeyboard
import com.example.besakina.viewmodel.LoginNumberViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val loginNumberViewModel: LoginNumberViewModel by viewModels()
    private lateinit var loader: androidx.appcompat.app.AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loader = requireActivity().loadingDialog(true)

        binding.sendBtn.setOnClickListener {
            val validNumber = binding.mobileNumberLay.helperText == null && binding.mobileNumberTxt.text.toString().isNotEmpty()

            if(validNumber){
                if(requireActivity().isConnectedToInternet()){
                    loginNumberViewModel.loginNumber(binding.mobileNumberTxt.text.toString().toLong())
                    loader.show()
                }else{
                    Toast.makeText(requireActivity(),"Oops!! No internet connection,", Toast.LENGTH_LONG).show()
                }
            }else{
                if(binding.mobileNumberLay.helperText == null) binding.mobileNumberLay.helperText = "required"
                Toast.makeText(requireActivity(),binding.mobileNumberLay.helperText.toString(), Toast.LENGTH_SHORT).show()
                binding.mobileNumberTxt.showKeyboard()
            }
        }

        //observer
        loginNumberObserver()

        //listener
        numberFocusListener()
    }

    private fun loginNumberObserver(){
        loginNumberViewModel.response.observe(viewLifecycleOwner, Observer { outcome ->
            loader.dismiss()
            when(outcome){
                is Outcome.Success ->{
                    loader.dismiss()
                    if(outcome.data?.success == true){
                        Toast.makeText(requireActivity(),outcome.data!!.data?.otp.toString(), Toast.LENGTH_LONG).show()
                        val bundle = Bundle()
                        bundle.putString("mobile", binding.mobileNumberTxt.text.toString())
                        bundle.putString("otp", outcome.data!!.data?.otp.toString())
                        findNavController().navigate(R.id.action_loginFragment_to_loginOtpFragment, bundle)
                        loginNumberViewModel.navigationComplete()
                    }else{
                        loader.dismiss()
                        Toast.makeText(requireActivity(),outcome.data!!.message, Toast.LENGTH_SHORT).show()
                    }
                }
                is Outcome.Failure<*> -> {
                    Toast.makeText(requireActivity(),outcome.e.message, Toast.LENGTH_SHORT).show()
                    loader.dismiss()
                    outcome.e.printStackTrace()
                    Log.i("status",outcome.e.cause.toString())
                }

                else -> {
                    loader.dismiss()
                }
            }
        })
    }

    private fun numberFocusListener() {
        binding.mobileNumberTxt.doOnTextChanged { text, start, before, count ->
            binding.mobileNumberLay.helperText = validNumber()
        }
    }

    private fun validNumber(): String? {
        val numberText = binding.mobileNumberTxt.text.toString()

        if(numberText.isEmpty()){
            return "provide mobile number."
        }
        return  null
    }
}