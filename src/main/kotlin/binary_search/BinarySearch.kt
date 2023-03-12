package binary_search

class BinarySearch {

    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + ((right - left) / 2) // to avoid overflow --> 10 + ((20 - 10) / 2) = 15
            val mid2 = (left + right) / 2 // this is prone to overflow --> (10 + 20) / 2 = 15

            if (nums[mid] == target) {
                return mid
            } else if (nums[mid] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return -1
    }

    fun searchRecusive(nums: IntArray, target: Int): Int {
        return searchRecusive(nums, target, 0, nums.size - 1)
    }

    fun searchRecusive(nums: IntArray, target: Int, left: Int, right: Int): Int {
        if (left > right)
            return -1

        val mid = left + (right - left) / 2

        return if (nums[mid] == target) {
            mid
        } else if (nums[mid] < target) {
            searchRecusive(nums, target, mid + 1, right)
        } else {
            searchRecusive(nums, target, left, mid - 1)
        }
    }
}