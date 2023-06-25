package CodingTest.graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * package : CodingTest.graph.BFS
 * class name : No1012.java
 * date : 2023-06-24 오후 11:32
 * note : 유기농 배추 / silver 2 / BFS
 */
public class No1012{
    static int[][] map;
    static int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static int M, N, X;


    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-- > 0){
            //케이스 시작
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());// 가로 길이
            N = Integer.parseInt(st.nextToken());// 세로 길이
            X = Integer.parseInt(st.nextToken());//배추 개수

            map = new int[N][M];
            for(int i = 0; i < X; i++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            int cnt = 0;
            for(int i = 0; i < N;i++){
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 1){
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt+"\n");

        }//케이스 끝
        System.out.println(sb);
    }
    static void bfs(int i, int j){

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        queue.offer(j);
        map[i][j] = -1;
        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M
                        || map[nx][ny] <= 0){
                    continue;
                }
                map[nx][ny] = -1;
                queue.offer(nx);
                queue.offer(ny);

            }

        }
    }
}
