package CodingTest.DP_dynamic_programming.silver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * package : CodingTest.DP_dynamic_programming
 * class name : No1463.java
 * date : 2023-06-30 오후 10:37
 * info : 정수를 1로 만들기 / silver 3 / DP
 */
public class No1463{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n < 4 ? 4 : n + 1];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for(int i = 4; i <= n;i++){
            dp[i] = dp[i-1] + 1;
            if(i%2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
            if(i%3 == 0){
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
