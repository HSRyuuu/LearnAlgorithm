package CodingTest.DP_dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * package : CodingTest.DP_dynamic_programming
 * class name : No12865.java
 * date : 2023-07-02 오후 9:52
 * info : 평범한 배낭 / gold 5 / DP
 * link : https://www.acmicpc.net/problem/12865
 */
public class No12865{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        int[][] dp = new int[N+1][K + 1];
        int[] weight = new int[N + 1];
        int[] value = new int[N + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            weight[i] =  Integer.parseInt(st.nextToken());
            value[i] =  Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            //i는 물건들의 번호 , j는 가방에 넣을 수 있는 무게,
            for (int j = 1; j <= K ; j++) {
                //무게가 i번째 무게를 담을 수 있는 경우
                if(weight[i] <= j){
                    //dp[i-1][j] : i-1번째까지 봤을 때 최대 무게
                    // dp[i-1][j-weight[i]] + value[i] : i-1번재 까지 봤을 때 남는 무게에서 값을 가져옴 + 이번 item의 가치
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
                }else{
                    // 담을 수 없는 경우 : 이전 것을 그대로 가져옴
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
