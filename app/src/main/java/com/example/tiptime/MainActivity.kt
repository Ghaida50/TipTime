package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    //todo {1} declare binding
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val View = binding.root
        setContentView(View)
        //todo {2} create action on calculate button
        binding.calculateButton.setOnClickListener { calculateTip() }//end setOnClickListener
    }//end onCrate()

    //todo {3} create calculate tip function
    fun calculateTip() {
        //todo {3} get edit text value from the user
        val stringCost = binding.costOfService.text.toString()
        val cost = stringCost.toDouble()
        //todo {4} check the selected radiobutton
        val selectedId = binding.tipOptions.checkedRadioButtonId
        //todo {5} check the percent to use
        val tipPercentage = when (selectedId) {
            binding.optionTwentyPercent.id -> 0.20
            binding.optionEighteenPercent.id -> 0.18
            else -> 0.15
        }//end when
        //todo {6} calculating tip
        val Tip = cost * tipPercentage
        //todo {7} calculating total
        var total = Tip + cost
        // todo {8} check if round up switch is checked to round (use ceil function)
        if (binding.roundUpSwitch.isChecked) {
            total = kotlin.math.ceil(total)
        }//end if
        //todo {9} formatting the tip result
        val formattedTip = NumberFormat.getCurrencyInstance().format(total)
        binding.tipAmount.text = getString(R.string.tip_amount, formattedTip)
    }//end calculateTip()
}//end class