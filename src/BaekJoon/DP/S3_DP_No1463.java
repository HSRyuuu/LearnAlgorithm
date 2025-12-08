package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @문제명: 1로 만들기
 * @Tear: S3
 * @Algorithm: DP
 */
public class S3_DP_No1463 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    StringTokenizer st = new StringTokenizer(br.readLine()); // 첫번째줄 읽음

    int num = Integer.parseInt(st.nextToken());

    int[] dp = new int[num > 4 ? num + 1 : 4];
    dp[0] = 0;
    dp[1] = 0;
    dp[2] = 1;
    dp[3] = 1;
    for (int i = 4; i <= num; i++) {
      dp[i] = dp[i - 1] + 1;
      if (i % 2 == 0) {
        dp[i] = Math.min(dp[i], dp[i / 2] + 1);
      }
      if (i % 3 == 0) {
        dp[i] = Math.min(dp[i], dp[i / 3] + 1);
      }
    }
    System.out.println(dp[num]);
  }
}
