package CodingTest.search.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No7576 {
    // 7576번 : 토마토
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[][] board;
    static int n,m;
    static int[][] visited;
    static int days = 0;
    static List<int[]> startList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); // 가로
        n = Integer.parseInt(st.nextToken()); //세로
        board = new int[n][m];
        visited = new int[n][m];
        List<int[]> startList = new ArrayList<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==1){
                    startList.add(new int[]{i,j});
                }
            }
        }
        if(isAllRipen()){
            System.out.println(0);
        }else{
            BFS(startList);
        }
    }
    public static void BFS(List<int[]> startList) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<startList.size();i++){
            queue.offer(startList.get(i));
        }

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            for(int k=0;k<4;k++){
                int x = now[0]+dx[k];
                int y = now[1]+dy[k];

                if(x<0 || y<0 || x>=n || y>=m) continue;
                if(board[x][y] !=0) continue;

                board[x][y] = board[now[0]][now[1]]+1;

                queue.offer(new int[]{x,y});

                days = Math.max(board[x][y],days);
            }
        }
        if(isAllRipen()){
            System.out.println(days-1);
        }else System.out.println(-1);

    }
    public static boolean isAllRipen(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==0)return false;
            }
        }
        return true;
    }
}
