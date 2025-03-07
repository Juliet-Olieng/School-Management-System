package com.olieng.school_management.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.olieng.school_management.R
import com.olieng.school_management.data.SchoolData
import com.olieng.school_management.viewholder.SchoolAdapter

class SchoolFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var schoolAdapter: SchoolAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_school, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Sample Data
        val schoolList = listOf(
            SchoolData(23454,"Greenwood Academy", "28 Jan 1999","NewYork","JuniorSchool"),
            SchoolData(21455,"sunrise High School", "1 dec 2002","California","JuniorSchool"),
            SchoolData(23456,"Bright Future Institute", "1 nov 1998","Texas","JuniorSchool"),
            SchoolData(23474,"Springfield Academy", "30 dec 2000","Florida","JuniorSchool"),
        )

        schoolAdapter = SchoolAdapter(schoolList)
        recyclerView.adapter = schoolAdapter
    }
}
