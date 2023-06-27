package CodingTest.graph.벨만_포드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * package : CodingTest.graph.벨만_포드
 * class name : No11657.java
 * date : 2023-06-27 오후 8:40
 * note : 타임머신 / gold 4 / 벨만 포드
 * https://www.acmicpc.net/problem/11657
 * distance배열을 int형으로 만들면 출력초과 오류가 뜸
 */
public class No11657{
    static class Edge{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(N == 1){
            return;
        }

        long[] distance = new long[N+1];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[1] = 0;

        Edge[] cities = new Edge[M];
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            cities[i] = new Edge(a, b, time);
        }

        boolean isMinusCycle = false;
        for(int i = 1 ; i <= N; i++){
            for (int j = 0; j < M; j++) {
                Edge cur = cities[j];

                if(distance[cur.from] == Long.MAX_VALUE){
                    continue;
                }
                if(distance[cur.to] > distance[cur.from] + cur.weight){
                    distance[cur.to] = distance[cur.from] + cur.weight;

                    if(i == N){
                        isMinusCycle = true;
                    }
                }
            }
        }
        if(isMinusCycle){
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            if(distance[i] == Long.MAX_VALUE){
                sb.append(-1).append("\n");
            }else{
                sb.append(distance[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
