package CodingTest.search.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No24479 {
    // 24479번 : 알고리즘수업 깊이우선탐색1
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static StringBuilder sb = new StringBuilder();
    static int[] answer;
    static int sequence = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드 수
        int m = Integer.parseInt(st.nextToken()); // 간선 수
        int r = Integer.parseInt(st.nextToken()); // 시작 정점

        visited = new boolean[n + 1];
        A = new ArrayList[n + 1];
        answer = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            A[node1].add(node2);
            A[node2].add(node1);
        }
        //문제에서 오름차순으로 방문해야한다고 명시되어있다.
        for (int i = 1; i <= n; i++) {
            Collections.sort(A[i]);
        }

        DFS(r);

        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }
    static void DFS(int v){
        if(visited[v]) return;
        visited[v] = true;
        answer[v] = sequence++;

        for(int i : A[v]) {
            if(!visited[i]) DFS(i);
        }
    }

}
