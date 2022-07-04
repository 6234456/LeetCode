package eu.qiou.leetcode
// https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
class CutCake {
    fun maxArea(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {
        val h = (listOf(0) +  horizontalCuts.sorted() + listOf(h)).map{it.toLong()}
        val v = (listOf(0) +  verticalCuts.sorted() + listOf(w)).map{it.toLong()}
        val tmp = 1_000_000_007L

        return (h.drop(1).zip(h.dropLast(1)).map { it.first-it.second }.max()!!.rem(tmp) * v.drop(1).zip(v.dropLast(1)).map { it.first-it.second }.max()!!.rem(tmp)).rem(tmp).toInt()
    }

// https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/
    //1444
    fun ways(pizza: Array<String>, k: Int): Int {
        return ways(pizza.map { it.split("").map { if (it=="A") 1 else 0 } }, k)
    }

    fun ways(pizza: List<List<Int>>, k: Int): Int {
        if (k > pizza.sumBy { it.sum() })
            return 0

        if (k == 1)
            return 1

        val p = trim(pizza)
        val d = dimension(p)

        if (k == 2)
            return d

        return 0


    }

    fun trim(pizza: List<List<Int>>):List<List<Int>>{
        return transpose(pizza.filter { it.any { it == 1 } }).filter { it.any { it == 1 } }
    }

    fun dimension(pizza: List<List<Int>>): Int{
        if (pizza.isEmpty())
            return 0

        return pizza.size + pizza.first().size - 2
    }

    fun transpose(pizza: List<List<Int>>):List<List<Int>> {
        if (pizza.isEmpty())
            return pizza

        return pizza.foldIndexed(pizza.first().map { listOf(it) }){
            index, acc, ints ->
                if (index == 0)
                    acc
                else
                    ints.zip(acc).map { it.second + listOf(it.first) }
        }
    }
}