package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class No1260 {
    //1260번 : DFS와 BFS
    static boolean[] dfsVisited;
    static boolean[] bfsVisited;
    static ArrayList<Integer>[] lists;
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder dfsBuilder = new StringBuilder();
    static StringBuilder bfsBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        dfsVisited = new boolean[n+1];
        bfsVisited = new boolean[n+1];
        lists = new ArrayList[n+1];

        for(int i=0;i<=n;i++){
            lists[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            lists[node1].add(node2);
            lists[node2].add(node1);
        }

        for(int i=1;i<=n;i++){
            Collections.sort(lists[i]);
        }

        DFS(start);
        BFS(start);

        System.out.println(dfsBuilder);
        System.out.println(bfsBuilder);

    }
    public static void DFS(int node){
        if(dfsVisited[node]) return;

        dfsVisited[node] = true;
        dfsBuilder.append(node+" ");
        for(int i : lists[node]){
            if(!dfsVisited[i]){
                DFS(i);
            }
        }
    }
    public static void BFS(int node){
        queue.offer(node);

        while(!queue.isEmpty()){
            int now = queue.poll();

            if(!bfsVisited[now]){
                bfsBuilder.append(now+" ");
            }
            bfsVisited[now] = true;

            for(int i : lists[now]){
                if(!bfsVisited[i]){
                    queue.offer(i);
                }
            }
        }
    }
}
