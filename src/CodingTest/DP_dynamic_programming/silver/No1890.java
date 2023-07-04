package CodingTest.DP_dynamic_programming.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * package : CodingTest.DP_dynamic_programming.silver
 * class name : No1890.java
 * date : 2023-07-04 오전 12:08
 * info : 점프 / silver 1 / DP
 * link : https://www.acmicpc.net/problem/1890
 */
public class No1890{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long[][] dp = new long[N+1][N+1];
        dp[1][1] = 1;

        for(int i = 1; i <= N; i++){
            for (int j = 1; j <= N ; j++) {
                int cur = board[i][j];
                if(cur == 0)break;
                if(i + cur <= N){
                    dp[i+cur][j] += dp[i][j];
                }
                if(j + cur <= N){
                    dp[i][j + cur] += dp[i][j];
                }
            }
        }
        System.out.println(dp[N][N]);

    }
}
