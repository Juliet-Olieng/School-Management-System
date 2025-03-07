package com.olieng.school_management.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.olieng.school_management.R
import com.olieng.school_management.data.SchoolData


class SchoolViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val schoolName: TextView = itemView.findViewById(R.id.tvSchoolName)
    private val schoolId: TextView = itemView.findViewById(R.id.tvSchoolId)
    private val country: TextView = itemView.findViewById(R.id.tvCountry)
    private val createdAt: TextView = itemView.findViewById(R.id.tvCreatedAt)
    private val organization: TextView = itemView.findViewById(R.id.tvOrgName)


    fun bind(school: SchoolData) {
        schoolName.text = school.name
        schoolId.text = school.id.toString()
        country.text=school.country
        createdAt.text=school.createdAt
        organization.text=school.organizationName
    }
}


