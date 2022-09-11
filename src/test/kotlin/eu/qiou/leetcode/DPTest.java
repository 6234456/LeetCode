package eu.qiou.leetcode;

import junit.framework.TestCase;

import java.util.ArrayList;

public class DPTest extends TestCase {

    public void testMaxSumSubmatrix() {
        int[][] input = {{2,2,-1}};
        assertEquals(2, new DP().maxSumSubmatrix(input, 2));



    }


}