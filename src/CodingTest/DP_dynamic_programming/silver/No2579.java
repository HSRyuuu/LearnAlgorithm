package CodingTest.DP_dynamic_programming.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * package : CodingTest.DP_dynamic_programming.silver
 * class name : No2579.java
 * date : 2023-07-14 오전 12:12
 * info : 계단 오르기 / silver 3 / DP
 */
public class No2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        int[] arr = new int[N + 1];

        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        if(N == 1){
            System.out.println(arr[1]);
            return;
        }
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];

        for(int i = 3; i <= N; i++){
            dp[i] = Math.max(dp[i-2], dp[i-3]+arr[i-1]) + arr[i];
        }
        System.out.println(dp[N]);


    }
}
