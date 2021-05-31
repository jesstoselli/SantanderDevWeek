package com.jess.santanderdevweek.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jess.santanderdevweek.R
import com.jess.santanderdevweek.data.Account
import com.jess.santanderdevweek.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = null

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        getClientAccount()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_notification -> {
                Log.d("CLICK", "Notification item clicked")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getClientAccount() {
        mainViewModel.getClientAccount().observe(this, Observer {
            onBindView(it)
        })
    }

    private fun onBindView(account: Account) {
        binding.tvBranch.text = account.branch
        binding.tvAccount.text = account.accountNumber
        binding.tvBalance.text = account.balance
        binding.tvBalanceLimitValue.text = account.limit
        binding.tvUser.text = account.client.name
        binding.tvCardEndedInValue.text = account.card.cardNumber
    }
}