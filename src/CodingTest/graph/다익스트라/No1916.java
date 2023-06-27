package CodingTest.graph.다익스트라;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * package : CodingTest.graph.dijkstra
 * class name : No1916.java
 * date : 2023-06-27 오후 1:34
 * note : 최소 비용 구하기 / gold 5 / 다익스트라
 */
public class No1916{
    static class Edge{
        int to; //가리키는 도시
        int weight; // 비용

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static int N, M, start, target;
    static ArrayList<Edge>[] graph;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        N = Integer.parseInt(br.readLine()); // 도시의 개수
        M = Integer.parseInt(br.readLine()); // 버스의 개수

        distance = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s].add(new Edge(to,w));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
        pq.offer(new Edge(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            if(distance[cur.to] < cur.weight){
                continue;
            }
            for (int i = 0; i < graph[cur.to].size(); i++) {
                Edge tmp = graph[cur.to].get(i);
                int next = tmp.to;
                int weight = tmp.weight;

                if(distance[next] > distance[cur.to] + weight){
                    distance[next] = distance[cur.to] + weight;
                    pq.offer(new Edge(next, distance[next]));
                }
            }
        }
        System.out.println(distance[target]);
    }
}
