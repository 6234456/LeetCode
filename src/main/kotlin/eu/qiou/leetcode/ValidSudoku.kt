package eu.qiou.leetcode

// #36 https://leetcode.com/problems/valid-sudoku/

class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        //test rows
        return checkRow(board) &&
                checkRow(transpose(board)) && checkRow(slice(board))
    }

    private fun CharArray.frequency(): Map<Char, Int> = this.fold(mutableMapOf()){
        acc, c ->
        acc[c] = acc.getOrDefault(c, 0) + 1
        acc
    }

    private fun checkRow(board: Array<CharArray>): Boolean {
        return board.all { it.frequency().filterKeys { it != '.' }.all { it.value < 2 }}
    }

    fun transpose(board: Array<CharArray>): Array<CharArray>{
       return board.foldIndexed(board.first().map { charArrayOf(it)}.toTypedArray()){
           index, acc, chars ->
           if (index == 0)
               acc
           else
               chars.zip(acc) .map { it.second + it.first }.toTypedArray()
       }
    }

    fun slice(board: Array<CharArray>): Array<CharArray>{
        return  sliceRow(board.take(3)) + sliceRow(board.drop(3).take(3))+ sliceRow(board.drop(6))
    }

    private fun List<Char>.toCharArray() = this.fold(charArrayOf()){
        acc, c ->
        acc + c
    }

    private fun sliceRow(board: List<CharArray>): Array<CharArray> {
        return     arrayOf(
            board.map { it.take(3).toCharArray() }.fold(charArrayOf()){ acc, chars -> acc + chars },
            board.map { it.drop(3).take(3).toCharArray() }.fold(charArrayOf()){ acc, chars -> acc + chars },
            board.map { it.drop(6).toCharArray() }.fold(charArrayOf()){ acc, chars -> acc + chars }
        )
    }
}