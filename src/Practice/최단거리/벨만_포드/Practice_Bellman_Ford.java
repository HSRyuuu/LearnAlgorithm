package Practice.최단거리.벨만_포드;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 벨만 포드
 * 백준 11657번 : 타임머신 참고
 * 음수 간선이 있는 경우
 * 음수 사이클 확인 필요
 */
public class Practice_Bellman_Ford {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 3; //노드 수
        int start = 1; //시작점
        int[][] data = {{1, 2, 4}, {1, 3, 3}, {2, 3, -1}, {3, 1, -2}};
        String result = sol.bellman_ford(n, start, data);
        System.out.println("case 1 : " + result+"\n");

        //음수 사이클이 있는 경우
        n = 3;
        start = 1;
        int[][] data2 = {{1, 2, 4}, {1, 3, 3}, {2, 3, -4}, {3, 1, -2}};
        result = sol.bellman_ford(n, start, data2);
        System.out.println("case 2 : " + result+"\n");

        //갈 수 없는 도시(INF)가 있는 경우
        n = 3;
        start = 1;
        int[][] data3 = {{1, 2, 4}, {1, 2, 3}};
        result = sol.bellman_ford(n, start, data3);
        System.out.println("case 3 : " + result+"\n");
    }
}

/**
 *
 */
class Solution {
    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public String bellman_ford(int n, int start, int[][] data) {
        final Long INF = Long.MAX_VALUE;
        ArrayList<Edge> edges = new ArrayList<>();
        long[] distance = new long[n + 1];

        // 간선 리스트 초기화
        for (int i = 0; i < data.length; i++) {
            int s = data[i][0];
            int e = data[i][1];
            int w = data[i][2];
            edges.add(new Edge(s, e, w));
        }

        //distance 배열 초기화
        Arrays.fill(distance, INF);
        distance[start] = 0;

        //벨만포드 알고리즘 시작
        boolean isMinusCycle = false;
        //노드 개수(n) -1 만큼 반복(정상) , 마지막 n번째 반복에서 업데이트 발생 시 음수사이클
        for (int i = 1; i <= n; i++) {
            //이번 사이클에서 업데이트가 발생 했는지 확인
            boolean update = false;
            for (int j = 0; j < edges.size(); j++) {
                Edge cur = edges.get(j);

                if (distance[cur.to] > distance[cur.from] + cur.weight) {
                    distance[cur.to] = distance[cur.from] + cur.weight;
                    update = true;
                    if (i == n) {
                        isMinusCycle = true;
                        break;
                    }
                }
            }
            //업데이트가 발생하지 않는 경우 종료
            /*if (!update) {
                break;
            }*/
        }
        if (isMinusCycle) {
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < distance.length; i++) {
            if (distance[i] == INF) {
                sb.append("INF ");
            } else {
                sb.append(distance[i] + " ");
            }
        }
        return sb.toString();
    }
}