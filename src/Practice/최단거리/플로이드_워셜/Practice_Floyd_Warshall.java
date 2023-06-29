package Practice.최단거리.플로이드_워셜;

/**
 * 폴로이드 - 워셜 알고리즘
 * 백준 11404번 : 플로이드 참고
 */
public class Practice_Floyd_Warshall {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int n = 5; //도시 개수
        int[][] data =
                {{1, 2, 2}, {1, 3, 3}, {1, 4, 1}, {1, 5, 10}, {2, 4, 2},
                {3, 4, 1}, {3, 5, 1}, {4, 5, 3}, {3, 5, 10}, {3, 1, 8},
                {1, 4, 2}, {5, 1, 7}, {3, 4, 2}, {5, 2, 4}};
        String result = sol.floyd_warshall(n, data);
        System.out.println(result);
    }
}
class Solution{
    public String floyd_warshall(int n, int[][] data){
        final int INF = 1_000_000_000;

        //거리 배열 초기화
        int[][] distance = new int[n + 1][n + 1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(i != j){
                    distance[i][j] = INF;
                }
            }
        }

        //거리 배열에 간선 정보 적용
        for (int i = 0; i < data.length; i++) {
            int s = data[i][0];
            int e = data[i][1];
            int w = data[i][2];
            if(distance[s][e] < w){
                continue;
            }
            distance[s][e] = w;
        }

        //플로이드-워셜 알고리즘 시작
        for (int k = 1; k <= n ; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n ; j++) {
                    if(distance[i][k] == INF || distance[k][j] == INF){
                        continue;
                    }
                    //i -> j 와 i -> k -> j 를 비교해서 작은 값으로 저장
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
        //출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n ; j++) {
                if(distance[i][j] == INF){
                    sb.append(String.format("%5d", 0));
                }else{
                    sb.append(String.format("%5d", distance[i][j]));
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
