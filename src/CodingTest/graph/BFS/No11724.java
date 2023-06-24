package CodingTest.graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;
/**
 * package : CodingTest.graph.DFS
 * class name : No11724.java
 * date : 2023-06-17 오전 10:06
 * note : 연결 요소의 개수 / silver2 / 그래프, DFS, BFS
 *
 */

public class No11724{
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //노드 개수
        int M = Integer.parseInt(st.nextToken()); //간선 개수

        visited = new boolean[N+1];//0은 안씀
        graph = new ArrayList[N+1];//0은 안씀
        for(int i=0;i<N;i++){
            graph[i+1] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        int cnt = 0;
        for(int i=1;i<=N;i++){
            if(!visited[i]){
                cnt++;
                //둘중 하나만 사용
                DFS(i);
                //BFS(i);
            }
        }
        System.out.println(cnt);

    }
    static void DFS(int node){
        if(visited[node])return;
        visited[node] = true;
        for (int cur : graph[node]) {
            if(!visited[cur]){
                DFS(cur);
            }
        }
    }
    static void BFS(int node){
        queue.offer(node);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(!visited[cur]){
                visited[cur] = true;
            }
            for(int n : graph[cur]){{
                if(!visited[n]){
                    queue.offer(n);
                }
            }}
        }
    }

}