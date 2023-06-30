package CodingTest.DP_dynamic_programming.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * package : CodingTest.DP_dynamic_programming.silver
 * class name : No14501.java
 * date : 2023-06-30 오후 11:16
 * info : 퇴사 / silver 3 / DP
 */
public class No14501{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 2];
        int[] T = new int[n + 1];
        int[] P = new int[n + 1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = n; i > 0; i--){
            if(i + T[i] > n + 1){
                dp[i] = dp[i+1];
            }else{
                dp[i] = Math.max(dp[i+1], dp[i + T[i]] + P[i] );
            }
        }
        System.out.println(dp[1]);
    }
}
