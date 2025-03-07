package com.olieng.school_management.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.olieng.school_management.R
import com.olieng.school_management.data.CampsData


class CampsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val campName: TextView = itemView.findViewById(R.id.tvCampName)
    private val startDate: TextView = itemView.findViewById(R.id.tvStartDate)
    private val endDate: TextView = itemView.findViewById(R.id.tvEndDate)
    private val curriculum: TextView = itemView.findViewById(R.id.tvCurriculum)
    private val organizationId: TextView = itemView.findViewById(R.id.tvOrgId)
    private val schoolId :TextView = itemView.findViewById(R.id.tvSchoolId)


    fun bind(campsData: CampsData) {
        campName.text = campsData.name
        schoolId.text = campsData.schoolId.toString()
        startDate.text = campsData.startDate
        endDate.text = campsData.endDate
        curriculum.text = campsData.curriculum
        organizationId.text = campsData.organizationId.toString()
    }

    }