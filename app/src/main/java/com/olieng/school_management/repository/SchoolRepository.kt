package com.olieng.school_management.repository

import androidx.lifecycle.LiveData
import com.olieng.school_management.School2
import com.olieng.school_management.data.SchoolDb
import com.olieng.school_management.model.SchoolData
import com.olieng.school_management.viewModel.SchoolViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SchoolRepository {
    val database =SchoolDb.getDatabase(School2.appContext)
    suspend fun saveSchool(schoolData: SchoolData){
        withContext(Dispatchers.IO){
            database.schoolDao().insertSchool(schoolData)
        }
    }
    fun getDbSchool():LiveData<List<SchoolData>>{
        return database.schoolDao().getAllSchools()
    }
    fun getSchoolById(schoolId:Int):LiveData<SchoolData>{
        return database.schoolDao().getSchoolById(schoolId)
    }
}