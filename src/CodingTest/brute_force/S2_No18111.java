package CodingTest.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * package : CodingTest.brute_force
 * class name : S2_No18111.java
 * date : 2024-03-22 오후 2:28
 * info : 마인크래프트 / Silver 2 / brute force
 * link :
 */
public class S2_No18111 {

    static int bestTime = Integer.MAX_VALUE;
    static int height = 0;
    static int N, M, block;
    static int[][] ground;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        block = Integer.parseInt(st.nextToken());

        ground = new int[N][M];

        int max = Integer.MIN_VALUE;
        int min = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int cur = Integer.parseInt(st.nextToken());
                ground[i][j] = cur;
                max = Math.max(max, cur);
                min = Math.min(min, cur);
            }
        }

        for(int i = max; i >= min; i--){
            solution(i);
        }

        System.out.println(bestTime + " " + height);
    }
    static void solution(int target){
        int inventory = block;
        int time = 0;
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++){
                int cur = ground[i][j];
                if(cur > target){
                    int diff = cur - target;
                    time += 2 * diff;
                    inventory += diff;
                }else if(cur < target){
                    int diff = target - cur;
                    time += diff;
                    inventory -= diff;
                }
            }
        }
        if(inventory < 0) return;
        if(time < bestTime) {
            bestTime = time;
            height = target;
        }
    }
}