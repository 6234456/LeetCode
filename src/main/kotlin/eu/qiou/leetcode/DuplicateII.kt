package eu.qiou.leetcode

// https://leetcode.com/problems/contains-duplicate-ii/
class DuplicateII {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        if (nums.size < 2) return false

        return k >= nums.foldIndexed(mutableMapOf<Int, MutableList<Int>>()) { index, acc, i ->
            acc.apply {
                acc[i] = getOrDefault(i, mutableListOf()).apply {
                    add(index)
                }
            }
        }.values.filter { it.size > 1 }.let { x ->
            if (x.isEmpty())
                k + 1
            else
                x.map {
                    it.drop(1).zip(it)
                        .map { it.first - it.second }.min()
                }.minBy { it!! }!!
        }
    }
}