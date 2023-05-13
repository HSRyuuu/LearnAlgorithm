package baekjoon.search.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2178 {
    // 2178번 : 미로 탐색

    //상, 하, 좌, 우
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[][] map;
    static int n,m;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(str.substring(j,j+1));
            }
        }
        BFS(0,0);
        System.out.println(map[n-1][m-1]); //map의 각 인덱스에 depth 저장
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>(); // 좌표 x,y 저장
        queue.offer(new int[]{i,j});

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            visited[now[0]][now[1]] = true;

            //상하좌우 탐색
            for(int k=0;k<4;k++){
                int x = now[0]+dx[k];
                int y = now[1]+dy[k];

                if(x>=0 && y>=0 && x<n && y<m){ //map의 범위를 넘어서지 않았는지 확인
                    if(map[x][y]!=0 && !visited[x][y]){ //map의 인덱스가 0이 아닌지, 방문한적 없는지 확인
                        visited[x][y] = true;
                        map[x][y] = map[now[0]][now[1]]+1;
                        queue.offer(new int[]{x,y});
                    }
                }

            }
        }
    }
}