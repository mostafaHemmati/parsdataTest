package com.hemmati.parsdatapriject.presentation.show

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import com.hemmati.parsdatapriject.R
import com.hemmati.parsdatapriject.databinding.FragmentShowBinding
import com.hemmati.parsdatapriject.databinding.FragmentTransactionBinding
import com.hemmati.parsdatapriject.presentation.transaction.TransactionViewModel
import com.hemmati.parsdatapriject.util.showToast
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        statisticsViewModel.statisticsData.observe(viewLifecycleOwner){
//            showToast(it.toString())
        }
    }

}