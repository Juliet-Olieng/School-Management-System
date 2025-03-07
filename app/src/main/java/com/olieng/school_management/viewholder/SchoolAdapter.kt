package com.olieng.school_management.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.olieng.school_management.R
import com.olieng.school_management.data.SchoolData


class SchoolAdapter(private val schoolList: List<SchoolData>) : RecyclerView.Adapter<SchoolViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): SchoolViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.school_list, viewGroup, false)
        return SchoolViewHolder(v)
    }

    override fun getItemCount(): Int =
        schoolList.size


    override fun onBindViewHolder(holder: SchoolViewHolder, position: Int) {
        val school = schoolList[position]
        holder.bind(school)
    }

}
