package com.olieng.school_management.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.olieng.school_management.R
import com.olieng.school_management.databinding.ActivityAddSchoolBinding
import com.olieng.school_management.model.SchoolData
import com.olieng.school_management.viewModel.SchoolViewModel

class AddSchool : AppCompatActivity() {
    lateinit var binding: ActivityAddSchoolBinding
    val schoolViewModel:SchoolViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddSchoolBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    override fun onResume() {
        super.onResume()
        binding.btnCreate.setOnClickListener { validateSignup()  }
    }
    fun validateSignup(){
        val name=binding.etName.text.toString()
        val createdAt=binding.etCreatedAt.text.toString()
        val country=binding.etCountry.text.toString()
        val organization=binding.etOrganizaton.text.toString()
        var error=false

        if (name.isBlank()) {
            binding.tilName.error = "name required"
            error = true

        }
        if (createdAt.isBlank()){
            binding.tilCreatedAt.error="date created required"
            error=true

        }
        if (country.isBlank()){
            binding.tilCountry.error= "Country required"
            error=true

        }

        if(!error){
            val newSchool= SchoolData(
                schoolId = 0,
                name =name,
                createdAt = createdAt,
                country = country, organizationName = organization)
            schoolViewModel.saveContact(newSchool)
            Toast.makeText(this,"Contact created", Toast.LENGTH_SHORT)
                .show()
        }

    }
}