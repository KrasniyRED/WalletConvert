package com.bignerdranch.android.walletconvert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import com.bignerdranch.android.walletconvert.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.discountText.setText(getString(R.string.discountText,binding.discountBar.progress))
        binding.discountBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                binding.discountText.setText(getString(R.string.discountText,binding.discountBar.progress))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // you can probably leave this empty
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // you can probably leave this empty
            }
        })

        binding.priceActivityButton.setOnClickListener { view:View ->
            val price = binding.priceInput.text.toString()
            if(binding.dollarButton.isChecked){
                val intent = PriceActivity.newIntent(this@MainActivity,
                    price.toInt(),binding.discountBar.progress,75)
                startActivity(intent)
            }
            if(binding.euroButton.isChecked){
                val intent = PriceActivity.newIntent(this@MainActivity,
                    price.toInt(),binding.discountBar.progress,90)
                startActivity(intent)
            }
            if(binding.poundButton.isChecked){
                val intent = PriceActivity.newIntent(this@MainActivity,
                    price.toInt(),binding.discountBar.progress,100)
                startActivity(intent)
            }

        }





    }

}

