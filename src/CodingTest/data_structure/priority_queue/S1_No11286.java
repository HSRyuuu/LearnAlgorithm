package CodingTest.data_structure.priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * package : CodingTest.data_structure.priority_queue
 * class name : S1_No11286.java
 * date : 2024-03-12 오후 9:58
 * info : 절댓값 힙 / Silver1
 * link : 
 */
public class S1_No11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) ->{
            if(Math.abs(i1) == Math.abs(i2)){
                return i1 - i2;
            }
            return Math.abs((i1)) - Math.abs(i2);
        });

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            int cur = Integer.parseInt(br.readLine());
            if(cur != 0){
                pq.offer(cur);
                continue;
            }
            if(pq.isEmpty()) {
                sb.append(0).append("\n");
            }else{
                sb.append(pq.poll()).append("\n");
            }
        }
        System.out.println(sb);
    }
}