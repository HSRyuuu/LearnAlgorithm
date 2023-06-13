package CodingTest.brute_force;

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
        int[][] ground = new int[N][M];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max,ground[i][j]);
                min = Math.min(min,ground[i][j]);
            }
        }
        int ansTime = Integer.MAX_VALUE;
        int ansGnd = 0;
        for(int k=max;k>=min;k--){
            int curTime = 0;
            int inven = B;
            for(int i=0;i<N;i++){
                for (int j = 0; j < M; j++) {
                    int diff = k-ground[i][j];
                    if(diff<0){ //블록 제거
                        curTime-=diff*2;
                        inven-=diff;
                    }else{ //블록 추가
                        curTime +=diff;
                        inven-=diff;
                    }
                }
            }
            //max부터 반복문을 돌기 때문에 시간이 같은 경우는 무시
            if(inven>=0 && curTime<ansTime){
                ansTime = curTime;
                ansGnd = k;
            }
        }
        System.out.println(ansTime+" "+ansGnd);
    }
}