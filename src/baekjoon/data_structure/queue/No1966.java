package baekjoon.data_structure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int cases = Integer.parseInt(br.readLine());

        for(int i=0;i<cases;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());//문서의 개수
            int m = Integer.parseInt(st.nextToken());//몇번째에 놓여있는지
            String str = br.readLine();
            int result  = findOrder(n, m, str);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
    static int findOrder(int n, int m, String str){
        StringTokenizer st = new StringTokenizer(str);
        Queue<int[]> queue = new LinkedList<>();
        int order=1;
        for(int i=0;i<n;i++){
            //[0] : 번호 , [1] : 값
           int[] arr = {i,Integer.parseInt(st.nextToken())};
           queue.add(arr);
        }

        while(true){
            int[] peekArr = queue.peek();
            boolean ok = true;
            //전부다 돌면서 나보다 큰 값이 있나 확인
            for (int[] arr : queue) {
                if(peekArr[1]<arr[1]){
                    int[] pollAndAdd = queue.poll();
                    queue.add(pollAndAdd);
                    ok = false;
                    break;
                }
            }
            //나보다 큰 값이 있었으면 ok = false
            //나보다 큰 값이 없었으면 ok = true -> poll 하면 된다.
            if(ok && peekArr[0]==m){ //이번 값이 출력 가능하고, 찾고자 하는 번호랑 같으면 몇번째 출력인지 반환
                return order;
            }else if(ok && peekArr[0]!=m){
                int[] pollAndAdd = queue.poll();
                order++;
            }
        }
    }
}
