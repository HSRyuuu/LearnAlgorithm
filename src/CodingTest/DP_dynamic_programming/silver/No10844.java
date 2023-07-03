package CodingTest.DP_dynamic_programming.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * package : CodingTest.DP_dynamic_programming.silver
 * class name : No10844.java
 * date : 2023-07-03 오후 9:36
 * info : 쉬운 계단 수 / silver 1 / DP
 * link : https://www.acmicpc.net/problem/10844
 */
public class No10844{
    static final int DIVIDER = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][10]; //[계단 길이][계단 높이]

        for(int i = 1; i <=9 ; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N ; i++) {
            dp[i][0] = dp[i-1][1];
            dp[i][9] = dp[i-1][8];
            for (int j = 1; j <= 8 ; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % DIVIDER;
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[N][i]) % DIVIDER;
        }

        System.out.println(sum);

    }
}
