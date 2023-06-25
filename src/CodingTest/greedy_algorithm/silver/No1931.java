package CodingTest.greedy_algorithm.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

/**
 * package : CodingTest.greedy_algorithm
 * class name : No1931.java
 * date : 2023-06-25 오후 2:02
 * note : 회의실 배정 / silver 1 / 그리디
 */
public class No1931{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }else{
                return o1[1] - o2[1];
            }
        });
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{start, end});
        }


        int endTime = -1;
        int cnt = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[0] >= endTime){
                endTime = cur[1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}