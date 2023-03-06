package arrays_and_hashing

import org.junit.jupiter.api.Assertions.*

internal class ArraysAndHashingTests {
    @org.junit.jupiter.api.Test
    fun containsDuplicate() {
        val main = ArraysAndHashing()
        assertTrue(main.containsDuplicate(intArrayOf(1,2,3,1)))
        assertFalse(main.containsDuplicate(intArrayOf(1,2,3)))
    }
}