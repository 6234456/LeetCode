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

        if (ratings.size == 1)
            return 1

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
                    res = res + listOf(current to cnt)
                }
                res
        }

        // the value at the peak is the longer one of the two slopes
        return trend.foldIndexed(1) { index, acc, pair ->
            acc +if (pair.first == 0)
                pair.second
            else
               (1 + pair.second + 1) * (pair.second +1) / 2 - 1- if (index > 0 && trend[index-1].first == 1) kotlin.math.min(trend[index-1].second, pair.second) else 0
        }
    }
}