package com.hemmati.parsdatapriject.presentation.transaction

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hemmati.parsdatapriject.domain.exeption.ApiError
import com.hemmati.parsdatapriject.domain.model.Post
import com.hemmati.parsdatapriject.domain.usecase.GetTransactionUseCase
import com.hemmati.parsdatapriject.domain.usecase.base.UseCaseResponse
import kotlinx.coroutines.cancel

class TransactionViewModel constructor(private val getTransactionUseCase: GetTransactionUseCase) :
    ViewModel() {
    val transactionData = MutableLiveData<List<Post>>()
    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    fun getPosts() {
        showProgressbar.value = true
        getTransactionUseCase.invoke(
            viewModelScope, null,
            object : UseCaseResponse<List<Post>> {
                override fun onSuccess(result: List<Post>) {
                    transactionData.value = result
                    showProgressbar.value = false
                }

                override fun onError(apiError: ApiError?) {
                    messageData.value = apiError?.getErrorMessage()
                    showProgressbar.value = false
                }
            },
        )
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }

    companion object {
        private val TAG = TransactionViewModel::class.java.name
    }

}