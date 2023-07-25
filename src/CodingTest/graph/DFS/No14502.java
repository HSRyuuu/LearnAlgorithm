package CodingTest.graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * package : CodingTest.graph.DFS
 * class name : No14502.java
 * date : 2023-07-26 오전 12:02
 * info : 연구소 / gold 4 / dfs , bfs 둘다 사용
 * link : https://www.acmicpc.net/problem/14502
 */
public class No14502 {
    static int N, M;
    static int[][] map;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int maxArea = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(maxArea);
    }

    static void dfs(int wallCnt) {
        if (wallCnt == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wallCnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    queue.offer(i);
                    queue.offer(j);
                }
            }
        }
        int[][] cloneMap = getCloneMap();

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (cloneMap[nx][ny] == 0) {
                    queue.offer(nx);
                    queue.offer(ny);
                    cloneMap[nx][ny] = 2;
                }
            }
        }
        checkResult(cloneMap);
    }

    static void checkResult(int[][] cloneMap) {
        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cloneMap[i][j] == 0) {
                    safeArea++;
                }
            }
        }
        maxArea = Math.max(safeArea, maxArea);
    }

    static int[][] getCloneMap() {
        int[][] cloneMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            cloneMap[i] = map[i].clone();
        }
        return cloneMap;
    }

}
