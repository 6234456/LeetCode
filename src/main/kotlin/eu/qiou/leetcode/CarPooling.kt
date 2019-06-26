package eu.qiou.leetcode

/**
 * https://leetcode.com/contest/weekly-contest-142/problems/car-pooling/
 */
class CarPooling {
    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        val stations = IntArray(1001) { 0 }
        trips.fold(stations) { acc, e ->
            e[1].until(e[2]).forEach {
                acc[it] += e[0]
            }
            acc
        }
        return stations.max()!! <= capacity
    }
}