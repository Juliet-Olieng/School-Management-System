package com.olieng.school_management.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Schools")
data class SchoolData(
    @PrimaryKey(autoGenerate = true)var schoolId: Int,
    val name: String,
    val createdAt: String,
    val country: String,
    val organizationName: String,


    )
