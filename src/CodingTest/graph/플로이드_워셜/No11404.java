package CodingTest.graph.플로이드_워셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * package : CodingTest.graph.플로이드_워셜
 * class name : No11404.java
 * date : 2023-06-28 오후 6:59
 * note : 플로이드 / gold 4 / 플로이드_워셜 알고리즘 완전 기본
 */
public class No11404{
    static final int INF = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine()); //도시의 개수
        int M = Integer.parseInt(br.readLine()); //버스의 개수

        int[][] distance = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if(i != j){
                    distance[i][j] = INF;
                }
            }
        }

        StringTokenizer st;
        for(int i = 0 ; i < M;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(distance[a][b] < w){
                continue;
            }
            distance[a][b] = w;
        }

        for(int k = 1; k <= N; k++){
            for (int i = 1; i <= N ; i++) {
                for (int j = 1; j <= N ; j++) {
                    if(distance[i][k] == INF || distance[k][j] == INF){
                        continue;
                    }
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++ ){
            for (int j = 1; j <= N; j++) {
                if(distance[i][j] == INF){
                    sb.append(0+" ");
                }else{
                    sb.append(distance[i][j]+" ");
                }

            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
