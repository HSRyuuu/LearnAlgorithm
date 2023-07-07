package CodingTest.graph.BFS;

import java.util.*;

/**
 * package : CodingTest.graph.BFS
 * class name : P43162.java
 * date : 2023-07-08 오전 12:07
 * info : 네트워크 / lv3 / BFS
 * link : https://school.programmers.co.kr/learn/courses/30/lessons/43162
 */
class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        graph = new ArrayList[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                if(computers[i][j] == 1){
                    graph[i].add(j);
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(visited[i]){
                continue;
            }
            if(graph[i].size() == 0){
                visited[i] = true;
                cnt++;
                continue;
            }
            bfs(i);
            cnt++;
        }

        return cnt;
    }

    static void bfs(int i){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int x : graph[cur]){
                if(!visited[x]){
                    queue.offer(x);
                    visited[x] = true;
                }
            }
        }
    }

}
public class P43162 {
}
