package com.hemmati.parsdatapriject.presentation.transaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.hemmati.parsdatapriject.R
import com.hemmati.parsdatapriject.databinding.FragmentTransactionBinding
import com.hemmati.parsdatapriject.util.isNetworkAvailable
import com.hemmati.parsdatapriject.util.showIf
import com.hemmati.parsdatapriject.util.showToast
import kotlinx.android.synthetic.main.fragment_transaction.*
import org.koin.android.viewmodel.ext.android.viewModel


class TransactionFragment : Fragment() {
    private lateinit var fragmentTransactionBinding: FragmentTransactionBinding

    private val transactionViewModel: TransactionViewModel by viewModel()

    private lateinit var mPostsAdapter: PostsAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View {
        fragmentTransactionBinding = FragmentTransactionBinding.inflate(inflater, container, false)
        return fragmentTransactionBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialRecyclerView()
        viewModelStartAndObserved()
    }


    private fun initialRecyclerView() {
        fragmentTransactionBinding.recyclerView.apply {
            mPostsAdapter = PostsAdapter()
            layoutManager = LinearLayoutManager(activity)
            adapter = mPostsAdapter
        }
    }

    private fun viewModelStartAndObserved() {

        if (isNetworkAvailable())
            transactionViewModel.getPosts()
        else
            Toast.makeText(
                activity, getString(R.string.no_internet_connection),
                Toast.LENGTH_LONG
            ).show()

        with(transactionViewModel) {
            transactionData.observe(viewLifecycleOwner) {
                mPostsAdapter.mPostList = it
            }
            showProgressbar.observe(viewLifecycleOwner) { state ->
                progressBar.showIf { state }
            }
            messageData.observe(viewLifecycleOwner) {
                showToast(it)
            }

        }
    }
}