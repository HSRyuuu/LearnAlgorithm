package CodingTest.graph.BFS;

import java.util.LinkedList;
import java.util.Queue;
/**
 * package : CodingTest.graph.BFS
 * class name : P159993.java
 * date : 2023-06-25 오후 9:08
 * note : 미로 탈출 / lv2 / BFS
 */
public class P159993 {

    public static void main(String[] args) {
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        Solution sol = new Solution();
        System.out.println(sol.solution(maps));

        String[] maps2 = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
        System.out.println(sol.solution(maps2));
    }

    static class Solution {
        static int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        static int[][] map;
        static boolean isPossible = true;

        public int solution(String[] maps) {
            map = new int[maps.length][maps[0].length()];

            int[] start = new int[2];
            int[] lever = new int[2];
            int[] end = new int[2];

            for(int i = 0; i < maps.length; i++){
                String str = maps[i];
                for(int j = 0; j < maps[0].length();j++){
                    char ch = str.charAt(j);
                    if(ch == 'S'){
                        start[0] = i;
                        start[1] = j;
                    }else if(ch == 'L'){
                        lever[0] = i;
                        lever[1] = j;
                    }else if(ch == 'E'){
                        end[0] = i;
                        end[1] = j;
                    }else if(ch == 'X'){
                        map[i][j] = -1;
                    }
                }
            }

            bfs(start[0], start[1], lever);
            int startToLever = getValue(lever[0], lever[1]);

            if(startToLever == 0){
                return -1;
            }

            //맵 초기화
            initializeMap();

            bfs(lever[0], lever[1], end);
            int leverToEnd = getValue(end[0], end[1]);

            if(leverToEnd == 0){
                return -1;
            }

            return startToLever + leverToEnd;
        }

        static void bfs(int i, int j, int[] target){
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{i,j});

            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                int value = getValue(x, y);

                for(int[] dir : dirs){
                    int nx = dir[0] + x;
                    int ny = dir[1] + y;
                    if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length
                            || getValue(nx, ny) == -1 || getValue(nx, ny) != 0){
                        continue;
                    }

                    map[nx][ny] = value + 1;
                    if(nx == target[0] && ny == target[1]){
                        return;
                    }
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        static void initializeMap(){
            for(int i = 0; i < map.length; i++){
                for(int j = 0; j < map[0].length;j++){
                    if(map[i][j] != -1){
                        map[i][j] = 0;
                    }
                }
            }
        }

        static int getValue(int x, int y){
            return map[x][y];
        }
    }
}
