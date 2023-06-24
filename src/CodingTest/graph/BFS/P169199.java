package CodingTest.graph.BFS;
import java.util.*;

/**
 * package : CodingTest.graph.BFS
 * class name : P169199.java
 * date : 2023-06-24 오후 11:05
 * note : 리코쳇 로봇 / lv2 / BFS
 */
public class P169199 {

    static class Solution {
        static int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        static int[] robot = new int[3];
        static int[] target = new int[2];
        static int[][] map;
        static boolean[][] visited;
        public int solution(String[] board) {

            map = new int[board.length][board[0].length()];
            visited = new boolean[board.length][board[0].length()];

            for(int i = 0; i < map.length;i++){
                for(int j = 0;j < map[0].length;j++){
                    char ch = board[i].charAt(j);
                    if(ch == '.'){
                        map[i][j] = 0;
                    }else if(ch == 'D'){
                        map[i][j] = 1;
                    }else if(ch == 'G'){
                        map[i][j] = 9;
                        target[0] = i;
                        target[1] = j;
                    }else{
                        map[i][j] = 5;
                        robot[0] = i;
                        robot[1] = j;
                        robot[2] = 0;
                    }
                }
            }
            int ans = bfs();

            return ans;
        }
        static int bfs(){
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(robot);
            visited[robot[0]][robot[1]] = true;

            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                if(x == target[0] && y == target[1]){
                    return cur[2];
                }

                for(int[] dir : dirs){
                    int dx = dir[0];
                    int dy = dir[1];

                    if(x+dx < 0 || x+dx >= map.length || y+dy < 0 || y+dy >= map[0].length
                            || map[dir[0]+x][dir[1]+y] == 1){
                        continue;
                    }

                    int[] move = moveForward(dir, x, y);
                    int moveX = move[0];
                    int moveY = move[1];
                    if(!visited[moveX][moveY]){
                        move[2] = cur[2]+1;
                        queue.offer(move);
                        visited[moveX][moveY] = true;
                    }
                }

            }
            return -1;
        }
        static int[] moveForward(int[] dir, int x, int y){
            int[] result = new int[3];
            int dx = dir[0]; //1
            int dy = dir[1]; //
            //x : 0  y : 6
            int mult = 1;
            int nx = 0;
            int ny = 0;
            while(true){
                nx = dx*mult + x;
                ny = dy*mult + y;

                if(nx < 0 || nx >=map.length || ny < 0 || ny >= map[0].length || map[nx][ny] == 1){
                    result[0] = dx*(mult-1) + x;
                    result[1] = dy*(mult-1) + y;
                    break;
                }
                mult += 1;

            }
            return result;
        }
    }
    public static void main(String[] args) {
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        Solution sol = new Solution();

        System.out.println(sol.solution(board));

        String[] board2 = {".D.R", "....", ".G..", "...D"};
        System.out.println(sol.solution(board2));
    }
}
