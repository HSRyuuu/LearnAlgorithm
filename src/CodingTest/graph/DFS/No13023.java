package CodingTest.graph.DFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * package : CodingTest.graph.DFS
 * class name : No13023.java
 * date : 2023-06-17 오후 11:40
 * note : 13023번 : ABCDE / 조건부 DFS
 * https://www.acmicpc.net/problem/13023
 */
public class No13023{

    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static boolean isExist = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        visited = new boolean[N];
        for(int i=0;i<N;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        for(int i=0;i<N;i++){
            visited = new boolean[N];
            DFS(i,1);
            if(isExist){
                break;
            }
        }
        if(isExist){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
    static void DFS(int node, int cnt){
        if(cnt == 5){
            isExist = true;
            return;
        }
        visited[node] = true;
        for(int i : graph[node]){
            if(!visited[i]){
                DFS(i,cnt+1);
            }
            if(isExist){
                return;
            }
        }
        visited[node] = false;
    }
}
