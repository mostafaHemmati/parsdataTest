package com.hemmati.parsdatapriject.presentation.show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hemmati.parsdatapriject.databinding.FragmentShowBinding
import org.koin.android.viewmodel.ext.android.viewModel


class ShowFragment : Fragment() {

    private lateinit var fragmentShowFragment: FragmentShowBinding
    private val statisticsViewModel: StatisticsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentShowFragment = FragmentShowBinding.inflate(inflater, container, false)
        return fragmentShowFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        statisticsViewModel.statisticsData.observe(viewLifecycleOwner) {
            fragmentShowFragment.statistic = it
        }
    }
}