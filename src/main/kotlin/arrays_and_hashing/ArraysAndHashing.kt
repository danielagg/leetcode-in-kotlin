package arrays_and_hashing

class ArraysAndHashing {
    fun executeAll() {
        containsDuplicate(intArrayOf(1,2,3,1))
        containsDuplicate(intArrayOf(1,2,3))
    }

    fun containsDuplicate(nums: IntArray): Boolean {
        return nums.groupBy { it }.filterValues { it.size > 1 }.any()
    }
}