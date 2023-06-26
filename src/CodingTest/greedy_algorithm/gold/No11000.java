package CodingTest.greedy_algorithm.gold;
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
        // (1) 입력받은 강의의 우선순위를 정해준다.
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }else{
                return o1[0] - o2[0];
            }
        }));
        // (2) 강의를 입력받아서 pq에 저장한다.
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{start, end});
        }
        // (3) 강의실을 나타내고, 강의의 종료시간을 담을 우선순위 큐 room을 만든다.
        PriorityQueue<Integer> room = new PriorityQueue<>();
        room.offer(0);

        // (4) room에서 하나씩 값을 peek() 하여 값을 비교하고, poll()을 할지 말지 결정한다.
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
