package CodingTest.DP_dynamic_programming;
/**
 * package : CodingTest.DP_dynamic_programming
 * class name : P42898.java
 * date : 2023-07-20 오후 11:52
 * info : 등굣길 / lv 3 / DP
 * link : https://school.programmers.co.kr/learn/courses/30/lessons/42898
 */
class Solution {
    final int MOD = 1_000_000_007;
    static int[][] dp;

    public int solution(int m, int n, int[][] puddles) {
        dp = new int[m + 1][n + 1];
        for (int i = 0; i < puddles.length; i++){
            dp[puddles[i][0]][puddles[i][1]] = -1;
        }

        dp[1][1] = 1;

        for (int i = 1; i < m + 1; i++){
            for (int j = 1; j < n + 1; j++){
                if(dp[i][j] == -1){
                    continue;
                }

                if(dp[i - 1][j] > 0){
                    dp[i][j] += dp[i - 1][j] % MOD;
                }
                if(dp[i][j - 1] > 0){
                    dp[i][j] += dp[i][j - 1] % MOD;
                }
            }
        }
        return dp[m][n] % MOD;
    }
}
public class P42898 {
}
