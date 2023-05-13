package baekjoon.search.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No2606 {
    // 2606번 : 바이러스
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 노드 개수
        int m = Integer.parseInt(br.readLine()); // 에지 개수
        visited = new boolean[n+1]; //0은 안씀
        A = new ArrayList[n+1]; //ArrayList<Integer> 타입 배열

        for(int i=1;i<=n;i++) {
            A[i] = new ArrayList<>(); //배열의 각 요소마다 ArrayList를 가진다.
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 시작
            int e = Integer.parseInt(st.nextToken()); // 종료
            // 방향성이 없기 때문에 양쪽으로 넣어줌
            A[s].add(e);
            A[e].add(s);
        }
        // 노드1에서 시작, 1과 연결 안되어있으면 counting 하지 않으므로 한번만 실행해주면 된다.
        DFS(1);
        System.out.println(count-1); // 맨 처음 1번노드도 count 하기 때문에 -1
    }
    static void DFS(int v){
        if(visited[v]) return;

        visited[v] = true;
        count++; //노드를 추가로 방문할 때마다 count++

        for(int i : A[v]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }
}