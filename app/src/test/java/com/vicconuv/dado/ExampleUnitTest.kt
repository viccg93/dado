package com.vicconuv.dado

import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {
    @Test
    fun generates_number_within_range(){
        val myDice = Dice(6)
        assertTrue("El dado no genera valores correctos o en el rango especificado", myDice.roll() in 1..6)
    }
}