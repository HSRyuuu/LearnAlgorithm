package CodingTest.DP_dynamic_programming.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * package : CodingTest.DP_dynamic_programming.silver
 * class name : No1003.java
 * date : 2023-07-11 오후 11:50
 * info : 피보나치 함수 / silver 3 / dp
 * link : https://www.acmicpc.net/problem/1003
 */
public class No1003{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[T];
        int max = 0;
        for(int i = 0; i < T; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }
        int[][] dp = new int[41][2]; //x번째 수 / 0등장횟수, 1등장횟수
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for(int i = 2; i <= max; i++){
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        for(int i = 0; i < T; i++){
            sb.append(dp[arr[i]][0]).append(" ").append(dp[arr[i]][1]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}