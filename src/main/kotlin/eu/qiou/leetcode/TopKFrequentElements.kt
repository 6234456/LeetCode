package eu.qiou.leetcode

// https://leetcode.com/problems/top-k-frequent-elements/
// 347
class TopKFrequentElements {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        return nums.fold(mutableMapOf<Int, Int>()){
            acc, i ->
            if (acc.containsKey(i))
                acc[i] = acc[i]!! + 1
            else
                acc[i] = 0

            acc
        }.toList().sortedBy { it.second }.takeLast(k).map { it.first }.toIntArray()
    }
}