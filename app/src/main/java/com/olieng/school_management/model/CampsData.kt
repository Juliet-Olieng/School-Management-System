package com.olieng.school_management.model

data class CampsData(
    val name: String,
    val startDate: String,
    val endDate: String,
    val curriculum:String,
    val organizationId: Int,
    val schoolId:Int,
)
