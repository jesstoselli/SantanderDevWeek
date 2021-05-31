package com.jess.santanderdevweek.local

import com.jess.santanderdevweek.data.Account
import com.jess.santanderdevweek.data.Card
import com.jess.santanderdevweek.data.Client

class FakeData {

    fun getLocalData() = newAccount

    private val newAccount = Account(
        "02009247-8",
        "3861",
        "R$ 4.279,95",
        "R$ 5.317,95",
        Client("Jessyca"),
        Card("0234")
    )
}