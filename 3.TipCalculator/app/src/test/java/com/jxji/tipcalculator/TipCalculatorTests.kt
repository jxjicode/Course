package com.jxji.tipcalculator

import com.jxji.tipcalculator.calculateTip
import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {

    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, false)
//        val actualTip = "$2.00"
        assertEquals(expectedTip, actualTip)
    }

}