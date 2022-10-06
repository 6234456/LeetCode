package eu.qiou.leetcode


class StringManipulate {
    // "root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"
    // [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
    fun findDuplicate(paths: Array<String>): List<List<String>> {
        val reg = """(.+)\((.*)\)$""".toRegex()
        return paths.fold(listOf<Pair<String, String>>()){
            acc, s ->
             val tmp = s.split(" ")
            val pref = tmp[0]
            acc + tmp.drop(1).map { val g = reg.find(it)!!.groupValues;  g[2] to "$pref/${g[1]}" }
        }.groupBy { it.first }.values.map { it.map { it.second } }.filter { it.size > 1 }
    }

    fun numDecodings(s: String): Int {
        val dp = IntArray(s.length + 1){1}
        val a = s.toCharArray()
        val s1 = setOf('0', '1', '2', '3', '4', '5', '6')


        a.forEachIndexed{
                i, e ->
            if(i == 0){
                if(e == '0') return 0
                dp[1] = 1
            }else if(e == '0'){
                if(a[i-1] != '1' && a[i-1] != '2')
                    return 0

                dp[i + 1] = dp[i]
            }else{
                if(a[i-1] == '1' || (a[i-1] == '2' && e in s1)){
                    dp[i + 1] = dp[i] + dp[i - 1]
                }else{
                    dp[i + 1] = dp[i]
                }
            }
        }

        return dp.last()

    }
}