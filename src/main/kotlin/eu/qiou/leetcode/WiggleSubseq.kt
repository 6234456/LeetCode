package eu.qiou.leetcode

import kotlin.math.sign

class WiggleSubseq {
    // weavelet of delevopment
    // one consecutive up-/downward trend counted to be 1
    fun wiggleMaxLength(nums: IntArray): Int {
        val l = nums.size
        if (l == 1)
            return 1

        var u = 1
        var d = 1

        //the difference of upwards and downwards can at maximum be differentiated by 1
        // consecutive upward movement will not update the u variable. it depends on the u variable
        (1 until nums.size).forEach {  i ->
            if (nums[i]>nums[i-1])
                u = d + 1
            else if(nums[i] < nums[i-1])
                d = u + 1
        }

        return kotlin.math.max(u, d)
    }


    // https://leetcode.com/problems/candy/
    // 135

    fun candy(ratings: IntArray): Int {
        var current = 1
        var cnt = 1

        var total = 1
        var allitude = 1
        var lowest = allitude
        var preceedingNull = true

        val trend =  ratings.drop(1).zip(ratings.dropLast(1)).map {
           (it.first - it.second).sign
        }.foldIndexed(listOf<Pair<Int, Int>>()){
            index, acc, i ->
                var res = acc
                if (index == 0){
                    current = i
                }else{
                    if(current == i){
                        cnt++
                    }else{
                        res = acc + listOf(current to cnt)
                        cnt = 1
                        current = i
                    }
                }

                if (index == ratings.size - 2){
                    res = acc + listOf(current to cnt)
                }
                res
        }
            return trend.foldIndexed(1){
           index, acc, pair ->


            val res = acc + when(pair.first){
                1 ->{
                    val v = (pair.second + 1) * (allitude * 2 + pair.second) / 2 - if (!preceedingNull) allitude else 0
                    allitude += pair.first * pair.second
                    v
                }
                0 -> {
                    val adj = kotlin.math.max(0, 1 - lowest)
                    val tmp = (pair.second - 1) + adj * total
                    allitude = 1
                    lowest = 1
                    total = 1
                    tmp
                }
                -1 ->{
                    val v =  (pair.second + 1) * (allitude * 2 - pair.second) / 2 - if (!preceedingNull) allitude else 0
                    allitude += pair.first * pair.second
                    lowest = kotlin.math.min(lowest, allitude)
                    v
                }
                else -> throw java.lang.Error("")
            }

            preceedingNull = pair.first == 0

            total += pair.second


            if (index == trend.size - 1){
                if (pair.first == 0)
                    pair.second + res
                else{
                    val adj = kotlin.math.max(0, 1 - lowest)
                    res + adj * total
                }
            }else
            res

        }
    }
}