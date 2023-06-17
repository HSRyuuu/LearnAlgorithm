package CodingTest.graph.이분그래프;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1707{

    static int[] color; //방문 x : 0, RED : 1 , GREEN : -1
    static ArrayList<ArrayList<Integer>> graph;
    static String ans = "YES";
    static int RED = 1, GREEN = -1;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int cases = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0;i<cases;i++){
            ans = "YES";
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());//정점
            int E = Integer.parseInt(st.nextToken());//간선

            graph = new ArrayList<>();
            graph.add(new ArrayList<>());//0번인덱스 사용 x
            for(int j=0;j<V;j++){
                graph.add(new ArrayList<>());
            }

            for(int j=0;j<E;j++){
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());

                graph.get(node1).add(node2);
                graph.get(node2).add(node1);
            }
            color = new int[V+1];
            for(int j=1;j<=V;j++){
                if(color[j] == 0){
                    if(!BFS(j))break;
                }
            }
            sb.append(ans+"\n");

        }//cases
        System.out.println(sb);
    }
    public static boolean BFS(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        color[node] = RED; //처음 넣을때는 RED로 넣음

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int i : graph.get(cur)){
                //cur이랑 인접해 있는데, 색이 같으면 바로 ans = NO
                if(color[cur] == color[i]){
                    ans = "NO";
                    return false;
                }
                //color==0이면 방문한적 없는거니까, cur의 색에 *-1을 해서 저장
                if(color[i] == 0){
                    color[i] = color[cur]*-1;
                    queue.offer(i);
                }
            }
        }
        return true;
    }

}