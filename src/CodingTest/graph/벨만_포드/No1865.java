package CodingTest.graph.벨만_포드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * package : CodingTest.graph.벨만_포드
 * class name : No1865.java
 * date : 2023-06-28 오후 9:50
 * info : 웜홀 / gold 3 / 벨만포드
 * link :https://www.acmicpc.net/problem/1865
 * comment : 모든 노드를 시작점으로 해서 돌려봐야 함
 */
public class No1865{
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

    static long[] distance;
    static ArrayList<Edge> edges;
    static final long INF = Long.MAX_VALUE-Integer.MAX_VALUE;
    static int N, M, W;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();

            for (int i = 0; i < M + W ; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                if(i < M){
                    edges.add(new Edge(s, e, w));
                    edges.add(new Edge(e, s, w));
                }else{
                    edges.add(new Edge(s, e, w * -1));
                }

            }

            boolean isMinusCycle = false;

            //모든 노드를 시작점으로 하여 BF 메서드를 돌려봐야 함
            //하나라도 음수사이클이 있으면 반복 종료
            for(int i = 1; i <= N; i++){
                boolean result = BF(i);
                if(result){
                    isMinusCycle = true;
                    break;
                }
            }

            if(isMinusCycle){
                sb.append("YES\n");
            }else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb);
    }
    static boolean BF(int start){
        distance = new long[N + 1];

        Arrays.fill(distance, INF);
        distance[start] = 0;

        boolean isMinusCycle = false;
        boolean update = false;
        for (int i = 1; i <= N ; i++) {
            update = false;
            for (int j = 0; j < edges.size(); j++) {
                Edge cur = edges.get(j);

                if(distance[cur.to] > distance[cur.from] + cur.weight){
                    distance[cur.to] = distance[cur.from] + cur.weight;
                    update = true;
                    if(i == N){
                        isMinusCycle = true;
                    }
                }
            }
            //업데이트가 더이상 발생하지 않는 경우 종료 (시간초과 방지)
            if(!update){
                break;
            }
        }
        return isMinusCycle;
    }
}
