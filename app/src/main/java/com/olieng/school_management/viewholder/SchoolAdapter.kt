package com.olieng.school_management.viewholder

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.olieng.school_management.model.SchoolData
import com.olieng.school_management.databinding.SchoolListBinding


class SchoolAdapter(private val schoolList: List<SchoolData>, private val context: Context) : RecyclerView.Adapter<SchoolViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolViewHolder {
        val binding =SchoolListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SchoolViewHolder(binding)
    }

    override fun getItemCount(): Int =
        schoolList.size


    override fun onBindViewHolder(holder: SchoolViewHolder, position: Int) {
        val currentSchool = schoolList[position]
        val binding = holder.binding

        binding.tvSchoolId.text= currentSchool.schoolId.toString()
        binding.tvSchoolName.text= currentSchool.name
        binding.tvCreatedAt.text=currentSchool.createdAt
        binding.tvCountry.text= currentSchool.country
        binding.tvOrgName.text= currentSchool.organizationName

//        binding.tvCardView.setOnClickListener {
//            val intent=Intent(context, )
//        }

    }

}
class SchoolViewHolder(var binding: SchoolListBinding): RecyclerView.ViewHolder(binding.root){}
