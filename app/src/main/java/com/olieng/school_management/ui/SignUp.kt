package com.olieng.school_management.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.olieng.school_management.R
import com.olieng.school_management.databinding.ActivitySignupBinding

class SignUp : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btSignUp.setOnClickListener {
           registrationErrors()
        }
        binding.btSignUp.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun registrationErrors() {
        val password = binding.etPassword.text.toString()
        val firstname = binding.etFirstname.text.toString()
        val lastName = binding.etLastName.text.toString()
        val email = binding.etEmail.text.toString()

        val passwordConf = binding.etConfirmPassword.text.toString()

        var error = false
        if (firstname.isBlank()) {
            binding.TILFirstName.error = "Username_ is_ required "
            error = true
        }

        if (email.isBlank()) {
            binding.TIemail.error = "email is required"
            error = true
        }
        if (lastName.isBlank()) {
            binding.TILFirstName.error = "input last name"
        }

        if (password.isBlank()) {
            binding.TIPassword.error = "Password is required"
            error = true
        }
        if (password != passwordConf) {
            binding.TIConfirmPassword.error = "password doesn,t match"
            error = true
        }

//        if (!error) {
//            val registerRequest = RegisterRequest(
//                firstName = firstname,
//                email = email,
//                lastName = lastName,
//                password = password,
//                confirmPassword = passwordConf,
//
//
//                )
//            binding.pbProgressBar.visibility = View.VISIBLE
//            userViewModel.registerUser(registerRequest)
//        }
    }
}