package CodingTest.graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * package : CodingTest.graph.BFS
 * class name : No2667.java
 * date : 2023-06-19 오후 9:09
 * note : 단지 번호붙이기 / silver 1 / BFS
 */
public class No2667{
    static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static int N;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i=0;i<N;i++){
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }

        List<Integer> ansList = new LinkedList<>();

        for(int i=0;i<N;i++){
            for (int j = 0; j < N; j++) {
                if(board[i][j] == 1){
                    int bfs = BFS(i, j);
                    ansList.add(bfs);
                }
            }
        }

        Collections.sort(ansList);

        StringBuilder sb = new StringBuilder();
        sb.append(ansList.size()).append("\n");
        for (Integer i : ansList) {
            sb.append(i+"\n");
        }

        System.out.println(sb);
    }

    public static int BFS(int i, int j){
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        count++;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            board[cur[0]][cur[1]] = -1;

            for (int[] d : dir) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];

                if(x < 0 || y < 0 || x >= N || y >= N){
                    continue;
                }
                if(board[x][y] == 1){
                    queue.offer(new int[]{x, y});
                    board[x][y] = -1;
                    count++;
                }
            }
        }
        return count;
    }
}
