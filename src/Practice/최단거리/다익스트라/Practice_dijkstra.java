package Practice.최단거리.다익스트라;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 다익스트라
 * 백준 1753번 : 최단경로 참고
 */
public class Practice_dijkstra {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 5; //노드 수
        int start = 1; //시작점
        int[][] data = {{5, 1, 1}, {1, 2, 2}, {1, 3, 3}, {2, 3, 4}, {2, 4, 5}, {3, 4, 6}};
        String result = sol.dijkstra(5, 1, data);
        System.out.println(result);
    }
}

/**
 * data[][] 는 간선 정보이다.
 * data[x][0] : 출발 노드, data[x][1] : 도착노드 , data[x][2] : 가중치
 * n : 노드 수
 * start : 시작 노드
 * return : 모든 노드로의 최단거리 정보 출력
 */
class Solution{
    static class Edge{
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public String dijkstra(int n, int start, int[][] data){
        final int INF = 1_000_000_000;
        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        int[] distance = new int[n + 1];

        //그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < data.length; i++) {
            int s = data[i][0];//출발 노드
            int e = data[i][1];//도착 노드
            int w = data[i][2];//가중치
            graph[s].add(new Edge(e, w));
        }

        //distance 배열 초기화
        Arrays.fill(distance, INF);
        distance[start] = 0;

        //다익스트라 시작
        PriorityQueue<Edge> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
        boolean[] visited = new boolean[n + 1];
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge curNode = pq.poll();
            if(visited[curNode.to]){
                continue;
            }
            visited[curNode.to] = true;

            for (int i = 0; i < graph[curNode.to].size(); i++) {
                Edge tmp = graph[curNode.to].get(i);

                if(distance[curNode.to] == INF){
                    continue;
                }
                //업데이트 조건
                if(distance[tmp.to] > distance[curNode.to] + tmp.weight){
                    distance[tmp.to] = distance[curNode.to] + tmp.weight;
                    pq.offer(new Edge(tmp.to, distance[tmp.to]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < distance.length; i++) {
            if(distance[i] == INF){
                sb.append("INF ");
            }else{
                sb.append(distance[i]+" ");
            }
        }
        String result = sb.toString();
        return result;
    }
}
