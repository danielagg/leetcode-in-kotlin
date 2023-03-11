package arrays_and_hashing

class ArraysAndHashing {
    fun executeAll() {
        containsDuplicate(intArrayOf(1,2,3,1))
        isAnagram("anagram", "nagaram")
        groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
    }

    fun containsDuplicate(nums: IntArray): Boolean {
//        return nums.groupBy { it }.filterValues { it.size > 1 }.any()


//        nums.sort()
//        for (i in 0 until nums.size - 1) {
//            if (nums[i] == nums[i + 1]) {
//                return true
//            }
//        }
//        return false;

        val hs = HashSet<Int>()
        for (e in nums)
            if (!hs.add(e)) return true

        return false
    }

    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val map = HashMap<Char, Int>()
        for (c in s) {
            map[c] = map.getOrDefault(c, 0) + 1
        }

        for (c in t) {
            map[c] = map.getOrDefault(c, 0) - 1
        }

        for (c in map.keys) {
            if (map[c] != 0) return false
        }

        return true
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {

        val prevMap: HashMap<Int, Int> = HashMap()
        for (i in nums.indices) {
            val num = nums[i]
            val diff = target - num
            if (prevMap.containsKey(diff)) {
                return intArrayOf(prevMap[diff]!!, i)
            }
            prevMap[num] = i
        }
        return intArrayOf()
    }


    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val resultGroups = HashMap<String, MutableList<String>>()
        for (word in strs) {
            val charactersInWordSorted = word.toCharArray().sorted().joinToString("")
            if (!resultGroups.containsKey(charactersInWordSorted)) {
                resultGroups[charactersInWordSorted] = mutableListOf()
            }
            resultGroups[charactersInWordSorted]!!.add(word)
        }
        return resultGroups.values.toList()
    }
}