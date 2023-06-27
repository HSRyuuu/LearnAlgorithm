package CodingTest.graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * package :
 * class name : No1260.java
 * date : 2023-06-24 오후 1:51
 * note : DFS, BFS 기본 둘다 해보는 문제zB
 */
public class No1260 {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //노드의 개수
        int E = Integer.parseInt(st.nextToken()); //간선의 개수
        int start = Integer.parseInt(st.nextToken()); //start point


        //0번노드는 사용 x
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        //간선 연결
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        //"정점이 여러개인 경우에는 정점 번호가 작은 것을 먼저 방문"
        for(int i = 1; i <=N;i++){
            Collections.sort(graph.get(i));
        }

        visited = new boolean[N+1];
        dfs(start);

        sb.append("\n");

        visited = new boolean[N+1];
        bfs(start);

        System.out.println(sb);

    }
    public static void dfs(int node){
        if(visited[node]){
            return;
        }

        visited[node] = true;
        sb.append(node+" ");

        for(int x : graph.get(node)){
            if(!visited[x]){
                dfs(x);
            }
        }
    }
    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int poll = queue.poll();
            if(!visited[poll]){
                sb.append(poll+" ");
            }
            visited[poll] = true;

            for (int x : graph.get(poll)) {
                if(!visited[x]){
                    queue.offer(x);
                }
            }
        }

    }
}