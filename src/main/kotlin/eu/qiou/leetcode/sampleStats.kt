package eu.qiou.leetcode

/**
 * https://leetcode.com/contest/weekly-contest-142/problems/statistics-from-a-large-sample/
 */
class sampleStats {
    fun sampleStats(count: IntArray): DoubleArray {
        val cnt = count.reduce { acc, i -> acc + i }
        val medianCnt = if (cnt.rem(2) == 1)
            (cnt - 1) / 2 + 1 to (cnt - 1) / 2 + 1
        else
            cnt / 2 to cnt / 2 + 1
        return DoubleArray(5).apply {
            this[3] = 0.0
            var minReached = false
            var medianReached = false
            var medianExtra = false
            var max = 0
            var mode = 0
            var modeCnt = 0
            var sum = 0L
            var currentCnt = 0
            count.forEachIndexed { index, i ->
                if (i > 0) {
                    sum += index * i

                    if (i > modeCnt) {
                        mode = index
                        modeCnt = i
                    }

                    if (!minReached) {
                        this[0] = index.toDouble()
                        minReached = true
                    }

                    if (!medianReached) {
                        currentCnt += i
                        if (medianCnt.first == medianCnt.second) {
                            if (currentCnt >= medianCnt.first) {
                                medianReached = true
                                this[3] = index.toDouble()
                            }
                        } else {
                            if (currentCnt == medianCnt.first) {
                                this[3] = index.toDouble()
                                medianExtra = true
                            } else if (currentCnt >= medianCnt.second) {
                                if (medianExtra) {
                                    this[3] += index.toDouble()
                                    this[3] = this[3] / 2.0
                                } else {
                                    this[3] = index.toDouble()
                                }
                                medianReached = true
                            }
                        }
                    }

                    max = index
                }
            }

            this[1] = max.toDouble()
            this[2] = sum.toDouble() / cnt.toDouble()
            this[4] = mode.toDouble()
        }
    }
}