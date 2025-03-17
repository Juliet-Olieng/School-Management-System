package com.olieng.school_management.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Toast
import com.olieng.school_management.databinding.ActivityMainBinding
import com.olieng.school_management.repository.DataBaseHelper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dataBaseHelper: DataBaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataBaseHelper= DataBaseHelper(this)
        binding.btLogin.setOnClickListener {
            val loginEmail=binding.etEmail.text.toString()
            val loginPassword=binding.etPassword.text.toString()
            loginDataBase(loginEmail,loginPassword)
        }
        binding.tvSignUp.setOnClickListener {
            val intent=Intent(this,SignUp::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun loginDataBase(email:String,password:String){
        val userExists = dataBaseHelper.readUser(email,password)
        if (userExists){
            Toast.makeText(this,"Login successful",Toast.LENGTH_LONG).show()
            val intent=Intent(this, Homepage::class.java)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this,"Login Unsuccessful",Toast.LENGTH_LONG).show()
        }
    }

}