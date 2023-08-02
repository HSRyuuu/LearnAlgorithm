package CodingTest.greedy_algorithm.gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * package : CodingTest.greedy_algorithm.gold
 * class name : No19598.java
 * date : 2023-08-02 오후 7:32
 * info : 우선순위 큐, 그리디 / gold 5
 * link : https://www.acmicpc.net/problem/19598
 */
public class No19598{
    static class Meeting{
        int start;
        int end;
        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;
        int max = 0;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Meeting> pq = new PriorityQueue<>((x, y) -> {
            if(x.start == y.start){
                return x.end - y.end;
            }else{
                return x.start - y.start;
            }
        });

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            pq.offer(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        PriorityQueue<Integer> room = new PriorityQueue<>();
        while(!pq.isEmpty()){
            Meeting m = pq.poll();
            if(room.isEmpty()){
                room.offer(m.end);
            }else{
                if(room.peek() <= m.start){
                    room.poll();
                    room.offer(m.end);
                }else{
                    room.offer(m.end);
                }
            }
            max = Math.max(room.size(), max);
        }
        System.out.println(max);


    }
}