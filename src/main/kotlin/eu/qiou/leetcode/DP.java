package eu.qiou.leetcode;

import java.util.*;

public class DP {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = Integer.MIN_VALUE;

        int[][] sumArray = new int[n][m];

        for(int i=0; i < m; i++){
            sumArray[0][i] = matrix[i][0];
        }

        for(int i=1; i < n; i++){
            for(int j=0; j < m; j++){
                sumArray[i][j] =  sumArray[i-1][j] + matrix[j][i];
            }
        }



        for(int i=0; i < n; i++){
            for(int j=i; j < n; j++){

                int end = 0;

                TreeSet<Integer> cum_set = new TreeSet<>();
                cum_set.add(0);

                for (int l = 0; l < m; l++) {
                    int sum = sumArray[j][l];

                    if (i > 0)
                        sum -= sumArray[i-1][l];

                    end += sum;

                    Integer start = cum_set.ceiling(end-k);

                    if (start != null){
                        res = Math.max(res, end - start );

                        if (res == k)
                            return k;
                    }

                    cum_set.add(end);

                }
            }
        }

        return  res;

    }

    long findMaxSubarraySum(long arr[], int n, int k) {
        long right = 0;
        TreeSet<Long> bst = new TreeSet<>();
        bst.add(0L);
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            right += arr[i];
            // right - left <= k -> left >= right - k
            Long left = bst.ceiling(right - k);
            if (left != null) {
                ans = Math.max(ans, right - left);
            }
            bst.add(right);
        }
        if (ans == Long.MIN_VALUE) return 0L; // not found!
        return ans;
    }
}
