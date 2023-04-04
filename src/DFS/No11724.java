package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No11724 {
    // 11724번 : 연결요소의 개수
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드 개수
        int m = Integer.parseInt(st.nextToken()); // 에지 개수
        visited = new boolean[n+1]; //0은 안씀
        A = new ArrayList[n+1]; //ArrayList<Integer> 타입 배열

        for(int i=1;i<=n;i++) {
            A[i] = new ArrayList<>();//배열의 각 요소마다 ArrayList를 가진다.
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 시작
            int e = Integer.parseInt(st.nextToken()); // 종료
            // 방향성이 없기 때문에 양쪽으로 넣어줌
            A[s].add(e);
            A[e].add(s);
        }
        int count = 0;
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }
    static void DFS(int v){
        if(visited[v]){
            return;
        }
        visited[v] = true;
        for(int i : A[v]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }
}