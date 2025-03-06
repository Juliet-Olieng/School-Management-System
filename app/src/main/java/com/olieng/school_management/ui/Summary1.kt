package com.olieng.school_management.ui

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.MPPointF
import com.olieng.school_management.R
import com.olieng.school_management.databinding.FragmentSummary1Binding


class SummaryFragment : Fragment(R.layout.fragment_summary1) {

    private var _binding: FragmentSummary1Binding? = null // Declare the ViewBinding variable
    private val binding get() = _binding!! // Safe access to the binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout using ViewBinding
        _binding = FragmentSummary1Binding.inflate(inflater, container, false)

        // Initialize the PieChart view using ViewBinding
        val pieChart = binding.pieChart // Access PieChart view from the binding

        // Set chart properties
        pieChart.apply {
            setUsePercentValues(true)
            description.isEnabled = false
            setExtraOffsets(5f, 10f, 5f, 5f)
            setDragDecelerationFrictionCoef(0.95f)
            setDrawHoleEnabled(true)
            setHoleColor(Color.WHITE)
            setTransparentCircleColor(Color.WHITE)
            setTransparentCircleAlpha(110)
            holeRadius = 58f
            transparentCircleRadius = 61f
            setDrawCenterText(true)
            rotationAngle = 0f
            isRotationEnabled = true
            isHighlightPerTapEnabled = true
            animateY(1400, Easing.EaseInOutQuad)
            legend.isEnabled = false
            setEntryLabelColor(Color.WHITE)
            setEntryLabelTextSize(12f)
        }

        // Create data entries for the pie chart
        val entries = ArrayList<PieEntry>().apply {
            add(PieEntry(70f, "Android"))
            add(PieEntry(20f, "iOS"))
            add(PieEntry(10f, "Other"))
        }

        // Create data set for the pie chart
        val dataSet = PieDataSet(entries, "Mobile OS").apply {
            setDrawIcons(false)
            sliceSpace = 3f
            iconsOffset = MPPointF(0f, 40f)
            selectionShift = 5f

            // Set slice colors
            val colors = arrayListOf(
                resources.getColor(R.color.purple_200),
                resources.getColor(R.color.yellow),
                resources.getColor(R.color.red)
            )
            this.colors = colors
        }

        // Create PieData object and apply it to the PieChart
        val data = PieData(dataSet).apply {
            setValueFormatter(PercentFormatter())
            setValueTextSize(15f)
            setValueTypeface(Typeface.DEFAULT_BOLD)
            setValueTextColor(Color.WHITE)
        }

        pieChart.data = data

        // Refresh the chart
        pieChart.invalidate()

        return binding.root // Return the root view of the binding
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clean up the binding to avoid memory leaks
        _binding = null
    }
}
