package eu.qiou.leetcode

class MinimumDeletions {
    fun minDeletions(s: String): Int {
        s.toCharArray().fold(mutableMapOf<Char, Int>()){
            acc, c ->
                acc[c] = 1 + acc.getOrDefault(c, 0)
                acc
        }.values.fold(mutableMapOf<Int, Int>()){
            acc, i ->
                acc[i] = 1 + acc.getOrDefault(i, 0)
                acc
        }.let {
            val k = it.keys.sorted()
            var totalVacany = 0

            // abstract to the frequency counter
            // if the frequency appears 1, it is neutral
            // if = 0, it can hold redandency  -1 * it. if there is no redan. it should be neutral
            // if > 1,  it provides redandency  it
            return (k.last() downTo 0).fold(0){
                acc, i ->
                    val f = it.getOrDefault(i, 0)
                    val res = acc + if(totalVacany == 0 && f <= 1) 0 else (f-1) * i
                totalVacany += f - 1
                totalVacany = kotlin.math.max(totalVacany, 0)
                res
            }
        }
    }
}