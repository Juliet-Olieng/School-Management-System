package com.olieng.school_management.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.olieng.school_management.R
import com.olieng.school_management.databinding.ActivitySignupBinding
import com.olieng.school_management.repository.DataBaseHelper

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var dataBaseHelper: DataBaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataBaseHelper= DataBaseHelper(this)

        binding.btSignUp.setOnClickListener {
            val signUpFirstName= binding.etFirstname.text.toString()
            val signUpLastName= binding.etLastName.text.toString()
            val signUpEmail= binding.etEmail.text.toString()
            val signUpPassword= binding.etPassword.text.toString()
            signUpDatabase(signUpFirstName,signUpLastName,signUpEmail,signUpPassword)
            registrationErrors()
        }
        binding.btSignUp.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
    private fun signUpDatabase(firstName: String,lastName: String,email:String,password:String){
        val insertRowId= dataBaseHelper.insertUser(firstName,lastName,email,password)
        if(insertRowId != -1L){
            Toast.makeText(this,"signUp Successful",Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this,"signUp Unsuccessful",Toast.LENGTH_LONG).show()
        }

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

    }
}