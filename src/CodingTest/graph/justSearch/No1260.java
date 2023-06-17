package CodingTest.graph.justSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * package : CodingTest.graph.BFS
 * class name : No1260.java
 * date : 2023-06-16 오후 11:26
 * note : BFS와 DFS / silver2 / graph완전 탐색
 */
public class No1260{
    static boolean[] visited;
    static ArrayList<Integer>[] lists; //DFS를 위한 list형 배열
    static Queue<Integer> queue = new LinkedList<>();//BFS를 위한 큐
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //정점의 개수
        int M = Integer.parseInt(st.nextToken()); //간선의 개수 (케이스 수)
        int start = Integer.parseInt(st.nextToken()); //탐색 시작 정점

        visited = new boolean[N+1];
        lists = new ArrayList[N+1];

        //lists 초기화
        for(int i=0;i<=N;i++){
            lists[i] = new ArrayList<>();
        }
        //간선 - 노드 연결
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            //그래프는 양방향을 추가해줘야 한다.
            lists[node1].add(node2);
            lists[node2].add(node1);
        }

        //방문할 수 있는 정점이 여러개인 경우 정점 번호가 작은 것을 먼저 방문한다.
        for (int i = 1; i <= N; i++) {
            Collections.sort(lists[i]);
        }
        DFS(start);
        System.out.println(sb);

        //visiter, StringBuilder 초기화
        visited = new boolean[N+1];
        sb.setLength(0);
        BFS(start);
        System.out.println(sb);

    }
    public static void DFS(int node){
        if(visited[node])return;
        visited[node] = true;
        sb.append(node+" ");
        for (int n : lists[node]) {
            if(!visited[n]){
                DFS(n);
            }
        }
    }
    public static void BFS(int node){
        queue.offer(node);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(!visited[cur]){
                sb.append(cur+" ");
            }
            visited[cur] = true;

            for (int n : lists[cur]) {
                if(!visited[n]){
                    queue.offer(n);
                }
            }

        }
    }

}