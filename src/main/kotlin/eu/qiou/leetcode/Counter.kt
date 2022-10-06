package eu.qiou.leetcode

class Counter {
    fun findOriginalArray(changed: IntArray): IntArray {
        if(changed.size.rem(2) == 1)
            return intArrayOf()

        val l = changed.sorted()
        val cnt = l.groupingBy { it }.eachCount().toMutableMap()

        var ans = listOf<Int>()
        var index = 0

        l.forEach{
                i ->

            if(cnt[i] == 0)
                return@forEach

            if(i == 0){
                if(cnt[0]!!.rem(2) == 1)
                    return intArrayOf()


                ans = ans + (1 .. cnt[0]!!/2).map{0}
                cnt[0] = 0
            }


            if(!cnt.containsKey(i * 2) || cnt[i * 2] == 0)
                return intArrayOf()

            cnt[i] = cnt[i]!! - 1
            cnt[i*2] = cnt[i*2]!! - 1
            ans = ans + listOf(i)


        }

        if(cnt.values.all{it == 0})
            return ans.toIntArray()

        return intArrayOf()
    }
}