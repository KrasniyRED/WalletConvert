package com.bignerdranch.android.walletconvert

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bignerdranch.android.walletconvert.databinding.ActivityPriceBinding

const val EXTRA_PRICE = "com.bignerdranch.android.walletconvert.price"
const val EXTRA_DISCOUNT = "com.bignerdranch.android.walletconvert.discount"
const val EXTRA_WALLET = "com.bignerdranch.android.walletconvert.wallet"

class PriceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPriceBinding
    private var price = 0
    private var discount = 0
    private var wallet = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPriceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        price = intent.getIntExtra(EXTRA_PRICE,0)
        discount = intent.getIntExtra(EXTRA_DISCOUNT,0)
        wallet = intent.getIntExtra(EXTRA_WALLET,0)
        val resPrice = (price * wallet)*(1-(discount.toDouble()/100.0))
        binding.resultText.setText(getString(R.string.resultText,resPrice.toInt()))
    }


    companion object {
        fun newIntent(packageContext: Context, price: Int, discount:Int,wallet:Int): Intent {
            return Intent(packageContext, PriceActivity::class.java).apply {
                putExtra(EXTRA_PRICE, price)
                putExtra(EXTRA_DISCOUNT, discount)
                putExtra(EXTRA_WALLET, wallet)
            }
        }
    }
}