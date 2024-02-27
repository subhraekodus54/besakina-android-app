package com.example.besakina.ui.fragment

import android.content.Intent
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
import com.example.besakina.databinding.FragmentLoginOtpBinding
import com.example.besakina.model.repository.Outcome
import com.example.besakina.ui.activity.SetLocationActivity
import com.example.besakina.utils.PrefManager
import com.example.besakina.utils.isConnectedToInternet
import com.example.besakina.utils.loadingDialog
import com.example.besakina.utils.showKeyboard
import com.example.besakina.viewmodel.LoginOtpViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginOtpFragment : Fragment() {
    private var _binding: FragmentLoginOtpBinding? = null
    private val binding get() = _binding!!

    private val loginOtpViewModel: LoginOtpViewModel by viewModels()
    private lateinit var loader: androidx.appcompat.app.AlertDialog

    private lateinit var mobile: String
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

        val args = arguments
        if (args != null) {
             mobile = args.getString("mobile")!!
        }
        binding.textView2.text = "We have sent your verification code to ${mobile}"
        loader = requireActivity().loadingDialog(true)


        binding.verifyBtn.setOnClickListener {
            val validOtp = binding.otpEdTxt.error == null && binding.otpEdTxt.text.toString().isNotEmpty()

            if(validOtp){
                if(requireActivity().isConnectedToInternet()){
                    loginOtpViewModel.loginOtp(mobile.toLong(), binding.otpEdTxt.text.toString().toLong())
                    loader.show()
                }else{
                    Toast.makeText(requireActivity(),"Oops!! No internet connection,", Toast.LENGTH_LONG).show()
                }
            }else{
                if(binding.otpEdTxt.error == null) binding.otpEdTxt.error = "required"
                Toast.makeText(requireActivity(),binding.otpEdTxt.error.toString(), Toast.LENGTH_SHORT).show()
                binding.otpEdTxt.showKeyboard()
            }
        }

        //listener
        otpFocusListener()

        //observer
        otpObserver()
    }

    private fun otpObserver(){
        loginOtpViewModel.response.observe(viewLifecycleOwner, Observer { outcome ->
            loader.dismiss()
            when(outcome){
                is Outcome.Success ->{
                    loader.dismiss()
                    if(outcome.data?.success == true){
                        Toast.makeText(requireActivity(),outcome.data!!.message.toString(), Toast.LENGTH_LONG).show()

                        outcome.data!!.token?.let {
                            PrefManager.setKeyAuthToken(it)
                        }
                        PrefManager.setLogInStatus(true)
                        PrefManager.setMobile(mobile)

                        val intent = Intent(requireActivity(), SetLocationActivity::class.java)
                        startActivity(intent)
                        requireActivity().finish()
                        loginOtpViewModel.navigationComplete()
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

    private fun otpFocusListener() {
        binding.otpEdTxt.doOnTextChanged { text, start, before, count ->
            binding.otpEdTxt.error = validOtp()
        }
    }

    private fun validOtp(): String? {
        val numberText = binding.otpEdTxt.text.toString()

        if(numberText.isEmpty()){
            return "provide OTP."
        }
        return  null
    }
}