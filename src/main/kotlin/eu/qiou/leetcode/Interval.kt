package eu.qiou.leetcode

class Interval {
        fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
                val ans:MutableList<IntArray> = mutableListOf()
                var tmp: IntArray = newInterval

                intervals.forEachIndexed { index, e ->

                        if (tmp[1] < e[0]){
                                ans.add(tmp)
                                ans.addAll(intervals.drop(index))
                                return ans.toTypedArray()
                        }

                        if (tmp[0] > e[1]){
                                ans.add(e)
                        }else{
                                tmp = intArrayOf(Math.min(e[0], tmp[0]), Math.max(e[1], tmp[1]))
                        }
                }

                ans.add(tmp)

                return ans.toTypedArray()
        }

}