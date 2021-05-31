package com.jess.santanderdevweek.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jess.santanderdevweek.data.Account
import com.jess.santanderdevweek.local.FakeData

class MainViewModel : ViewModel() {

    private val mutableLiveData = MutableLiveData<Account>()

    fun getClientAccount(): LiveData<Account> {
        mutableLiveData.value = FakeData().getLocalData()

        return mutableLiveData
    }

}