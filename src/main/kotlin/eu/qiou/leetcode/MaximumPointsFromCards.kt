package eu.qiou.leetcode
// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
class MaximumPointsFromCards {
    fun maxScore(cardPoints: IntArray, k: Int): Int {
        val l = cardPoints.size
        val total = cardPoints.reduce { acc, i ->  acc + i}

        if (k >= l)
            return total

        var ans = cardPoints.slice(0 until l-k).fold(0) { acc, i ->  acc + i}
        var tmp = ans

        (l-k until l).forEach {
            // think the opposite by remove the consecutive slice / slice and reduce array is inefficient if the chuck is huge.  just add and remove the elements by hand
            tmp += cardPoints[it] - cardPoints[it - (l-k)]
            ans = kotlin.math.min(ans, tmp)
        }

        return total - ans
    }
}