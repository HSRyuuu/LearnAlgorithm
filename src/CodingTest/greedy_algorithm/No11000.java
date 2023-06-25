package CodingTest.greedy_algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * package : CodingTest.greedy_algorithm
 * class name : No11000.java
 * date : 2023-06-25 오후 2:44
 * note : 강의실 배정 / gold 5 / 그리디
 */
public class No11000{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }else{
                return o1[0] - o2[0];
            }
        }));

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{start, end});
        }

        PriorityQueue<Integer> room = new PriorityQueue<>();
        room.offer(0);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(room.peek() <= cur[0]){
                room.poll();
            }
            room.offer(cur[1]);
        }

        System.out.println(room.size());
    }
}
