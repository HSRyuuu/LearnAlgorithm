package CodingTest.graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * package : CodingTest.graph.BFS
 * class name : No11725.java
 * date : 2023-06-26 오후 9:50
 * note : 트리의 부모 찾기 / silver 2 / BFS
 */
public class No11725{

    static ArrayList<Integer>[] graph;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        visited = new int[N+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < visited.length; i++) {
            sb.append(visited[i]+"\n");
        }
        System.out.println(sb);
    }
    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = -1;
        while(!queue.isEmpty()){
            int cur = queue.poll();

            for (int x : graph[cur]) {
                if(visited[x] != 0){
                    continue;
                }
                visited[x] = cur;
                queue.offer(x);
            }
        }

    }
}
