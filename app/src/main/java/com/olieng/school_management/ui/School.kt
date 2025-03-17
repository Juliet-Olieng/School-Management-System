package com.olieng.school_management.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.olieng.school_management.R
import com.olieng.school_management.databinding.FragmentSchoolBinding
import com.olieng.school_management.model.SchoolData
import com.olieng.school_management.viewModel.SchoolViewModel
import com.olieng.school_management.viewholder.SchoolAdapter

class SchoolFragment : Fragment() {

    private var _binding: FragmentSchoolBinding? = null
    private val binding get() = _binding!!
    private val schoolViewModel: SchoolViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSchoolBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = binding.fabAdd
        button.setOnClickListener {
            val intent = Intent(requireContext(), AddSchool::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        schoolViewModel.getSchool().observe(viewLifecycleOwner) { schoolList ->
            displaySchool(schoolList)
        }
    }


    private fun displaySchool(schoolList: List<SchoolData>) {
        val contactAdapter = SchoolAdapter(schoolList, requireContext())
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = contactAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

        // Sample Data
//        val schoolList = listOf(
//            SchoolData(23454,"Greenwood Academy", "28 Jan 1999","NewYork","JuniorSchool"),
//            SchoolData(21455,"sunrise High School", "1 dec 2002","California","JuniorSchool"),
//            SchoolData(23456,"Bright Future Institute", "1 nov 1998","Texas","JuniorSchool"),
//            SchoolData(23474,"Springfield Academy", "30 dec 2000","Florida","JuniorSchool"),
//        )

//        schoolAdapter = SchoolAdapter(schoolList)
//        recyclerView.adapter = schoolAdapter
//    }
//}
