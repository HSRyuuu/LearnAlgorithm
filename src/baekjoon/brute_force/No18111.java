package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 18111번 : 마인크래프트
 * 실버2
 */
public class No18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //세로
        int M = Integer.parseInt(st.nextToken()); //가로
        int B = Integer.parseInt(st.nextToken()); //처음 블록 개수

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[][] ground =  new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int v = Integer.parseInt(st.nextToken());
                ground[i][j] = v;
                min = Math.min(min, v);
                max = Math.max(max, v);
            }
        }

        int ansSeconds = Integer.MAX_VALUE;
        int ansHeight = -1;
        for(int i = min;i<=max;i++){
            int seconds = 0;
            int inventory = B;
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    int diff = ground[j][k] - i;

                    if(diff>0){ //블록 제거
                        seconds += Math.abs(diff)*2;
                        inventory += Math.abs(diff);
                    }else if(diff<0){// 블록 추가
                        seconds+=Math.abs(diff);
                        inventory-=Math.abs(diff);
                    }
                }
            }
            if(inventory>=0 && seconds <=ansSeconds){
                ansSeconds = seconds;
                ansHeight = i;
            }
        }
        System.out.println(ansSeconds+" "+ansHeight);

    }
}
