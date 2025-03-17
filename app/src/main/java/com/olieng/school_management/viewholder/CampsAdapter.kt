//package com.olieng.school_management.viewholder
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.olieng.school_management.R
//import com.olieng.school_management.model.CampsData
//
//
//class CampsAdapter(
//    private val onItemClick: List<CampsData>,
//    private val campList: (CampsData) -> Unit
//) : RecyclerView.Adapter<CampsViewHolder>() {
//    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CampsViewHolder {
//        val v = LayoutInflater.from(viewGroup.context)
//            .inflate(R.layout.camp_list, viewGroup, false)
//        return CampsViewHolder(v)
//    }
//
//    override fun getItemCount(): Int=campList.size
//
//    override fun onBindViewHolder(holder: CampsViewHolder, position: Int) {
//        val camps = campList[position]
//        holder.bind(camps)
//
//        holder.itemView.setOnClickListener {
//            onItemClick(camps)
//        }
//    }
//}
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.olieng.school_management.R
import com.olieng.school_management.model.CampsData
import com.olieng.school_management.viewholder.CampsViewHolder

class CampsAdapter(
    private val campList: List<CampsData>,
    private val onItemClick: (CampsData) -> Unit
) : RecyclerView.Adapter<CampsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CampsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.camp_list, parent, false)
        return CampsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CampsViewHolder, position: Int) {
        val camp = campList[position]
        holder.bind(camp)

        // Set click listener to navigate to CampDetailFragment
        holder.itemView.setOnClickListener {
            onItemClick(camp)
        }
    }

    override fun getItemCount(): Int = campList.size
}
