package com.olieng.school_management.ui
import CampsAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.olieng.school_management.R
import com.olieng.school_management.data.CampsData
import com.olieng.school_management.ui.CampDetailFragment


class CampsFragment : Fragment() {

    private lateinit var recyclerViewCamps: RecyclerView
    private lateinit var campAdapter: CampsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_camps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewCamps = view.findViewById(R.id.recycler_view)
        recyclerViewCamps.layoutManager = LinearLayoutManager(requireContext())

        // Sample Data
        val campList = listOf(
            CampsData("Summer Coding Camp", "2024-06-01", "2024-07-01", "Java & Kotlin", 1, 101),
            CampsData("AI Bootcamp", "2024-07-10", "2024-08-10", "Machine Learning", 2, 102),
            CampsData("Web Development Camp", "2024-08-15", "2024-09-15", "React & Node.js", 3, 103),
            CampsData("Data Science Camp", "2024-09-20", "2024-10-20", "Python & SQL", 4, 104)
        )

        // Handle item click to open detail screen
        campAdapter = CampsAdapter(campList) { selectedCamp ->
            openCampDetail(selectedCamp)
        }

        recyclerViewCamps.adapter = campAdapter
    }

    private fun openCampDetail(camp: CampsData) {
        val fragment = CampDetailFragment()

        // Pass data to detail fragment
        val args = Bundle().apply {
            putString("camp_name", camp.name)
            putString("start_date", camp.startDate)
            putString("end_date", camp.endDate)
            putString("curriculum", camp.curriculum)
            putInt("organization_id", camp.organizationId)
            putInt("school_id", camp.schoolId)
        }
        fragment.arguments = args

        // Navigate to the detail fragment
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.flFragment, fragment)
            .addToBackStack(null)
            .commit()
    }
}
