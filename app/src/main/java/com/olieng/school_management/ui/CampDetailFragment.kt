package com.olieng.school_management.ui
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.olieng.school_management.R

class CampDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_camp_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve arguments passed from CampFragment
        val campName = arguments?.getString("camp_name")
        val startDate = arguments?.getString("start_date")
        val endDate = arguments?.getString("end_date")
        val curriculum = arguments?.getString("curriculum")
        val organizationId = arguments?.getInt("organization_id")
        val schoolId = arguments?.getInt("school_id")

        // Find and set data to views
        view.findViewById<TextView>(R.id.tvDetailCampName).text = campName
        view.findViewById<TextView>(R.id.tvDetailStartDate).text = "Start Date: $startDate"
        view.findViewById<TextView>(R.id.tvDetailEndDate).text = "End Date: $endDate"
        view.findViewById<TextView>(R.id.tvDetailCurriculum).text = "Curriculum: $curriculum"
        view.findViewById<TextView>(R.id.tvDetailOrganizationId).text = "Organization ID: $organizationId"
        view.findViewById<TextView>(R.id.tvDetailSchoolId).text = "School ID: $schoolId"
    }
}
