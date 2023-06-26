package CodingTest.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1753{

    static class Edge    {
        int to; //가리키는 노드
        int weight; //가중치

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int V, E, start; //노드 개수, 간선 개수, 시작점
    static ArrayList<Edge>[] graph;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        distance = new int[V+1];
        graph = new ArrayList[V+1];

        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v,w));
        }
        //=== 초기화 끝 ===

        //=== 다익스트라 시작 ===
        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y)-> x.weight - y.weight);
        pq.add(new Edge(start, 0));
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

                if(distance[next] > distance[cur.to] + weight) {
                    distance[next] = distance[cur.to] + weight;
                    pq.offer(new Edge(next, distance[next]));
                }
            }
        }
        for (int i = 1; i <= V ; i++) {
            if(distance[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(distance[i]);
            }
        }
    }
}
