package CodingTest.graph.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Arrays;

/**
 * package : CodingTest.graph.다익스트라
 * class name : No1753.java
 * date : 2023-06-27 오후 8:43
 * note : 최단경로 / gold 4 / 다익스트라 알고리즘 완전 기본
 *
 * https://www.acmicpc.net/problem/1753
 */

public class No1753 {
    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[V + 1];
        int[] distance = new int[V + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;


        for (int i = 0; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        boolean[] visited = new boolean[V+1];
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(visited[cur.to]){
                continue;
            }
            visited[cur.to] = true;

            for (int i = 0; i < graph[cur.to].size(); i++) {
                Edge tmp = graph[cur.to].get(i);

                if (distance[cur.to] == Integer.MAX_VALUE) {
                    continue;
                }
                if (distance[tmp.to] > distance[cur.to] + tmp.weight) {
                    distance[tmp.to] = distance[cur.to] + tmp.weight;
                    pq.offer(new Edge(tmp.to, distance[tmp.to]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(distance[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}

