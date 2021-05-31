package com.jess.santanderdevweek.data

data class Account(
    val accountNumber: String,
    val branch: String,
    val balance: String,
    val limit: String,
    val client: Client,
    val card: Card
)
