package CodingTest.DP_dynamic_programming.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * package : CodingTest.DP_dynamic_programming.silver
 * class name : S3_No1003.java
 * date : 2024-02-28 오후 8:41
 * info : 피보나치 / 1003번
 * link :
 */
public class S3_No1003 {

    static int[][] dp;
    static int[] input;

    public static void main(String[] args) throws IOException {
        dp = new int[41][2];
        dp[0][0] = 1;
        dp[1][1] = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int cases = Integer.parseInt(br.readLine());
        input = new int[cases];

        int max = 0;
        for (int i = 0; i < cases; i++) {
            input[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, input[i]);
        }

        if (max < 2) {
            print();
            return;
        }

        for (int i = 2; i <= max; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
        print();

    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            sb.append(dp[input[i]][0]).append(" ").append(dp[input[i]][1]).append("\n");
        }
        System.out.println(sb);
    }

}