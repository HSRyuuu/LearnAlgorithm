package CodingTest.DP_dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * package : CodingTest.DP_dynamic_programming
 * class name : No2293.java
 * date : 2023-07-05 오후 11:24
 * info : 동전1 / gold 5 / DP
 * link : https://www.acmicpc.net/problem/2293
 */
public class No2293{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        // dp[k] = dp[k] + dp[k - coins[i]]
        int[] dp = new int[K + 1];
        dp[0] = 1;

        for(int i = 0; i < N; i++){
            for (int j = 1; j <= K; j++) {
                if(j >= coins[i]){
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        System.out.println(dp[K]);
    }
}
