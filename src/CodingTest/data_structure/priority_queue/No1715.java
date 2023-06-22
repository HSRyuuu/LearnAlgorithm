package CodingTest.data_structure.priority_queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * package : CodingTest.data_structure.priority_queue
 * class name : No1766.java
 * date : 2023-06-22 오후 11:46
 * note : 카드 정렬하기 / gold 4 / 우선순위큐
 */
public class No1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine()); // 카드의 수

        long ans = 0;
        for(int i = 0;i < N ; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }
        if(N == 1){
            System.out.println(0);
            return;
        }
        while(!pq.isEmpty()){
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            ans += sum;
            if(pq.isEmpty()){
                break;
            }else{
                pq.offer(sum);
            }
        }
        System.out.println(ans);
    }
}

