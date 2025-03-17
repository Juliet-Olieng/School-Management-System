package com.olieng.school_management.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.olieng.school_management.model.SchoolData

@Dao
interface SchoolDao {  // Renamed for clarity, as this is a Room DAO, not a Retrofit API interface
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSchool(schoolData: SchoolData)

    @Query("SELECT * FROM Schools")
    fun getAllSchools(): LiveData<List<SchoolData>>

    @Query("SELECT * FROM Schools WHERE schoolId = :schoolId")
    fun getSchoolById(schoolId: Int): LiveData<SchoolData>
}
