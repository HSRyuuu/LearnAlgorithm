package CodingTest.graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * package : CodingTest.graph.BFS
 * class name : No2583.java
 * date : 2023-07-23 오후 11:17
 * info : 영역 구하기 / silver 1 / BFS
 * link : https://www.acmicpc.net/problem/2583
 */
public class No2583 {
    static boolean[][] map;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new boolean[M][N];

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    map[i][j] = true;
                }
            }
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!map[i][j]) {
                    list.add(bfs(i, j));
                }
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb);
    }

    static int bfs(int i, int j) {
        int cnt = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        queue.offer(j);
        map[i][j] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                    continue;
                }
                if (!map[nx][ny]) {
                    map[nx][ny] = true;
                    queue.offer(nx);
                    queue.offer(ny);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
