package eu.qiou.leetcode

// [1,3,3,3,2,2,2,3,1] -> [1, 1]
class CandyCrush {
    fun run(l: List<Int>): List<Int> {
        // search for the activation point where more than 3 same elements in a row ends
        if (l.isEmpty()) return l

        // 1. group the same adjacent elements
        val l0 = group(l)

        // 2. find the possible activation points
        return l0.foldIndexed(mutableListOf<Int>()) { index, acc, mutableList ->
            if (mutableList.size >= 3) acc.add(index)
            acc
        }.let { x ->
            if (x.isEmpty()) l else x.map { trigger(l0, it).flatten() }.minBy { it.size }!!
        }
    }

    private fun group(l: List<Int>) = l.fold(mutableListOf<MutableList<Int>>()) { acc, e ->
        when {
            acc.isEmpty() -> acc.add(mutableListOf(e))
            acc.last().last() == e -> acc.last().add(e)
            else -> acc.add(mutableListOf(e))
        }
        acc
    }

    private fun trigger(l: List<List<Int>>, index: Int): List<List<Int>> = fusion(l.take(index), l.drop(index + 1))

    private fun fusion(left: List<List<Int>>, right: List<List<Int>>): List<List<Int>> {
        if (left.isNotEmpty() && right.isNotEmpty()
            && left.last().last() == right.first().first() && left.last().size + right.first().size >= 3
        )
            return fusion(left.dropLast(1), right.drop(1))

        return (left + right).let {
            if (it.size == 1 && it.first().size >= 3) emptyList() else it
        }
    }
}