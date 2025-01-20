
package com.example.fundamentoskotlin

import org.junit.Test
import org.junit.Assert.*

class ExampleUnitTest {
    @Test
    fun sum_shouldReturnTheAdditionOfTwoNumbers() {
        val result = sum(2, 3)
        assertEquals(5, result)
    }

    private fun sum(a: Int, b: Int): Int {
        return a + b
    }
}