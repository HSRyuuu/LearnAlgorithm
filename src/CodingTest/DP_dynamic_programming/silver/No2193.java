package CodingTest.DP_dynamic_programming.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * package : CodingTest.DP_dynamic_programming.silver
 * class name : No2193.java
 * date : 2023-06-30 오후 11:22
 * info : 이친수 / silver 3 / DP
 * link : https://www.acmicpc.net/problem/2193
 */
public class No2193{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][2];
        dp[1][1] = 1; //길이 = 1이고, 1로 끝나는 이친수의 개수
        dp[1][0] = 0;//길이 = 1이고, 0으로 끝나는 이친수의 개수

        for(int i = 2; i <= n; i++){
            dp[i][0] = dp[i-1][1] + dp[i-1][0];
            dp[i][1] = dp[i-1][0];
        }
        System.out.println(dp[n][0] + dp[n][1]);
    }
}