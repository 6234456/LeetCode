package eu.qiou.leetcode


//https://leetcode.com/problems/furthest-building-you-can-reach/
// #1642

class FurthestBuildingYouCanReach {
    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
        val biggest = java.util.PriorityQueue<Int>() // keep track of the biggest intervals to be over-gapped with ladders
        var total = 0
        var acc = 0
        var cnt = 0

        heights.dropLast(1).forEachIndexed {
                index, i ->
            val n = heights[index+1]
            if (n > i) {
                if (ladders > 0){
                    if (cnt < ladders){
                        biggest.add(n-i)
                        total += n-i
                        cnt++
                    }else{
                        val least = biggest.peek()
                        if(least < n-i){
                            biggest.poll()
                            biggest.add(n-i)
                            total += (n-i - least)
                        }
                    }
                }


                acc += n-i

                if (acc - total > bricks)
                    return index
            }
        }

        return heights.lastIndex
    }
}