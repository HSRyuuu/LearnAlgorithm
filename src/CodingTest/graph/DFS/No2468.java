package CodingTest.graph.DFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * package : CodingTest.graph.DFS
 * class name : No2468.java
 * date : 2023-06-23 오후 2:57
 * note : 안전 영역 / silver 1 / dfs (bfs로 하면 메모리 초과)
 */
public class No2468{
    static int[][] board;
    static boolean[][] visited;
    static int n;
    static int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, board[i][j]);
            }
        }


        int maxCnt = 1;
        //k : 높이
        for(int k = 1; k <= maxHeight; k++){
            int cnt = 0;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(board[i][j] > k && !visited[i][j]){
                        //bfs(k, i, j); //bfs 메모리 초과
                        dfs(k, i, j);
                        cnt++;
                    }
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        System.out.println(maxCnt);

    }

    static void dfs(int height, int x, int y) {
        visited[x][y] = true;

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]){
                continue;
            }
            if (board[nx][ny] > height) {
                dfs(height, nx, ny);
            }
        }
    }
    static void bfs(int height, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            visited[poll[0]][poll[1]] = true;

            for (int[] dir : dirs) {
                int nx = poll[0] + dir[0];
                int ny = poll[1] + dir[1];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]){
                    continue;
                }
                if (board[nx][ny] > height) {
                    queue.offer(new int[]{nx, ny});
                }
            }

        }
    }
}
