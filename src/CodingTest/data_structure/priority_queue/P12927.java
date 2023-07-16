package CodingTest.data_structure.priority_queue;

import java.util.*;

/**
 * package : CodingTest.data_structure.priority_queue
 * class name : P12927.java
 * date : 2023-07-16 오후 11:37
 * info : 야근 지수 / lv3 / 우선순위 큐
 * link : https://school.programmers.co.kr/learn/courses/30/lessons/12927
 */
class Solution {
    public long solution(int n, int[] works) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->y-x);
        for(int x : works){
            pq.offer(x);
        }

        while(n > 0){
            if(pq.isEmpty()){
                return 0;
            }
            int cur = pq.poll();
            n--;
            cur--;
            if(cur != 0){
                pq.offer(cur);
            }
        }

        long ans = 0;
        for(int x : pq){
            ans += (long)Math.pow(x, 2);
        }


        return ans;
    }
}
public class P12927 {
}
