package eu.qiou.leetcode

import org.junit.Test

class StringTestsTest {

    @Test
    fun isIsomorphic() {
        //println( StringTests.isIsomorphic("paper",  "title"))
/*
       println(StringTests.primesBefore(100))
        println(StringTests.isPrime(13))
        println((1..10).toList())
        println(StringTests.factorialPrime(10))
        println(StringTests.factorialPrime(820))
        println(StringTests.factorialPrime(5))

        println(StringTests.minSteps(820))
        println(StringTests.minSteps(5))

        println(StringTests.isPowerOfTwo(1024))
        println(StringTests.isPowerOfTwo(18))
  */
        println(StringTests.rob(listOf(6, 3, 10, 8, 2, 10, 3, 5, 10, 5, 3).toIntArray()))

        println(StringTests.twoSum(intArrayOf(3, 3), 6).toList())
        println(StringTests.plusOne(intArrayOf(9, 9, 9)).toList())

    }
}