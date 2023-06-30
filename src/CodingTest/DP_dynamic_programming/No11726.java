package CodingTest.DP_dynamic_programming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * package : CodingTest.DP_dynamic_programming
 * class name : No11726.java
 * date : 2023-06-30 오후 9:55
 * info : 2xn 타일링 / silver 3 / DP
 * link : https://www.acmicpc.net/problem/11726
 */
public class No11726{
    static final int DIVIDER = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n;i++){
            dp[i] = (dp[i-1] + dp[i-2])%DIVIDER;
        }
        System.out.println(dp[n]);

    }
}
