package eu.qiou.leetcode

import kotlin.math.pow

object StringTests {
    // https://leetcode.com/problems/isomorphic-strings/
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length)
            return false

        val map = mutableMapOf<Char, Char>()
        val map2 = mutableMapOf<Char, Char>()
        s.toCharArray().zip(t.toCharArray()).forEach {
            if (map.containsKey(it.first) && map[it.first]!! != it.second)
                return false

            if (map2.containsKey(it.second) && map2[it.second]!! != it.first)
                return false


            map.put(it.first, it.second)
            map2.put(it.second, it.first)
        }

        return true
    }

    fun isPowerOfTwo(n: Int): Boolean {
        val search = (0..30).map { 2f.pow(it).toInt() }

        return search.binarySearch(n) >= 0

    }

    // https://leetcode.com/problems/2-keys-keyboard/
    // 1 1 2 4 = 8   ->  6
    // 1 1 1 1 4 = 8  -> 6
    // 1 1 2 2 2 = 8  -> 6
    // 1 1 2 2 2 2 = 10 -> 7
    // 1 1 1 1 1 5 = 10 -> 7
    // 1 1 1 3 3 = 9 -> 6
    /**
     *  {2=1, 5=1}              -> 10  = 2 * 1 + 5 * 1
    {2=2, 5=1, 41=1}       -> 810 = 41 * 1 + 5 * 1 + 2 * 1
    {2=3}                   -> 8 = 2 * 3
     */
    fun minSteps(n: Int): Int {
        if (n == 1) return 0
        if (n == 2) return 2
        if (n == 3) return 3

        return factorialPrime(n).toList().fold(0) { acc, pair -> acc + pair.first * pair.second }
    }

    fun isPrime(n: Int): Boolean {
        for (x in 2..n - 1) {
            if (n.rem(x) == 0)
                return false
        }

        return true
    }

    fun primesBefore(n: Int): List<Int> {
        return (2..n).filter { isPrime(it) }
    }

    // invoke primeBefore to prepare the prime numbers first
    fun factorialPrime(n: Int): Map<Int, Int> {
        if (n <= 1)
            throw java.lang.Exception("ParameterException: n should be greater than 1")

        val PRIMES = primesBefore(n)

        if (PRIMES.contains(n)) {
            return mapOf(n to 1)
        }

        var tmp = n
        val res = mutableMapOf<Int, Int>()
        PRIMES.forEach {
            if (tmp == 1)
                return res

            var cnt = 0
            while (true) {
                if (tmp.rem(it) != 0) {
                    if (cnt > 0) {
                        res.put(it, cnt)
                    }
                    break
                }
                tmp /= it
                cnt++
            }
        }

        return res
    }

    fun moveZeroes(nums: IntArray): Unit {
    }


    fun twoSum(nums: IntArray, target: Int): IntArray {
        val m = nums.mapIndexed { index: Int, i: Int ->
            target - i to index
        }.toMap()

        nums.forEachIndexed { index, i ->
            if (m.containsKey(i) && m[i]!! != index)
                return intArrayOf(m[i]!!, index)
        }

        return IntArray(0)
    }

    fun plusOne(digits: IntArray): IntArray {

        var spare: Int = 1

        fun processDigit(n: Int): Int {
            val v = n + spare
            if (v >= 10) {
                spare = 1
                return v - 10
            }

            spare = 0
            return v
        }

        val res = mutableListOf<Int>()

        for (i in digits.lastIndex downTo 0) {
            res.add(processDigit(digits[i]))
        }

        if (spare == 1) {
            res.add(1)
        }

        return res.reversed().toIntArray()
    }


//https://leetcode.com/problems/house-robber-ii/
    /**
     *
     *
    Input: nums = [1,2,3,1]
    Output: 4
    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
    Total amount you can rob = 1 + 3 = 4.

    [1,3,1,3,100]
     *
     *
     */

    fun rob(nums: IntArray): Int {

        if (nums.isEmpty())
            return 0

        if (nums.size == 1)
            return nums.first()

        if (nums.size == 2)
            return Math.max(nums[0], nums[1])

        fun process(start: Int, end: Int): Int {
            val arr = IntArray(end)
            arr[start] = nums[start]
            arr[start + 1] = Math.max(nums[start], nums[start + 1])

            for (i in 2 until end) {
                arr[i] = Math.max(arr[i - 2] + nums[i], arr[i - 1])
            }

            // println(arr.toList())

            return arr.last()
        }

        return Math.max(process(0, nums.size - 1), process(1, nums.size))

    }

}