package eu.qiou.leetcode
// https://leetcode.com/problems/queue-reconstruction-by-height/
// 406
class QueueReconstruct {
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        // from high to short  merge the new array with acc
        // the second pos is the index in the new array
        val a = people.groupBy { it.first() }

        return a.keys.sortedDescending().fold(arrayOf()){
                acc, i ->
            merge(acc,a[i]!!.toTypedArray() )
        }
    }

    private fun merge(acc: Array<IntArray>, item: Array<IntArray>): Array<IntArray>{
        var cnt = 0
        var cnt_acc = 0
        var tmp = 0
        val l = item.size
        val l_acc = acc.size
        item.sortBy { it[1] }

        val res = Array<IntArray>(l + l_acc){IntArray(2)}

        while (cnt < l && cnt_acc < l_acc){
            res[tmp] = if (item[cnt][1] != tmp)
                acc[cnt_acc++]
            else
                item[cnt++]

            tmp++
        }

        while (cnt_acc < l_acc){
            res[tmp++] = acc[cnt_acc++]
        }

        while (cnt < l){
            res[tmp++] = item[cnt++]
        }

        return res
    }
}