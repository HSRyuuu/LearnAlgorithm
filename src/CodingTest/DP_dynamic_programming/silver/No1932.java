package CodingTest.DP_dynamic_programming.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * package : CodingTest.DP_dynamic_programming.silver
 * class name : No1932.java
 * date : 2023-07-06 오후 1:10
 * info : 정수 삼각형 / silver 1 / DP
 * link : https://www.acmicpc.net/problem/1932
 */
public class No1932{
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(N == 1){
            System.out.println(arr[0][0]);
            return;
        }

        for(int i = 0; i < N; i++){
            dp[N-1][i] = arr[N-1][i];
        }

        for(int i = dp.length - 2;i >= 0; i--){
            for (int j = 0; j <= i; j++) {
                int left = dp[i+1][j] + arr[i][j];
                int right = dp[i+1][j+1] + arr[i][j];
                dp[i][j] = Math.max(left, right);
            }
        }

        System.out.println(dp[0][0]);
    }
}
