package com.olieng.school_management.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olieng.school_management.model.SchoolData
import com.olieng.school_management.repository.SchoolRepository
import kotlinx.coroutines.launch

class SchoolViewModel: ViewModel() {
    val schoolRepo= SchoolRepository()
    lateinit var schoolLiveData: LiveData<SchoolData>
    fun saveContact(schoolData:SchoolData){
        viewModelScope.launch {
            schoolRepo.saveSchool(schoolData)
        }

    }

    fun getSchool(): LiveData<List<SchoolData>> {
        return schoolRepo.getDbSchool()
    }
    fun getSchoolById(contactId: Int){
        schoolLiveData= schoolRepo.getSchoolById(contactId)
    }


}