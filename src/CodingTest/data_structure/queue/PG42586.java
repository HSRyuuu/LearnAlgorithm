package CodingTest.data_structure.queue;

import java.util.*;
/**
 * package : CodingTest.data_structure.queue
 * class name : PG42586.java
 * date : 2023-06-13 오후 3:27
 * note : 기능개발 / 스택, 큐
 */
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new LinkedList<>();

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        for(int i=0;i<progresses.length;i++){
            queue.offer(progresses[i]);
            list.add(speeds[i]);
        }
        int day = 0;
        while(!queue.isEmpty()){
            day++;
            int cnt = 0;
            while(!queue.isEmpty() && queue.peek()+day*list.get(0)>=100){
                queue.poll();
                list.remove(0);
                cnt++;
            }
            if(cnt!=0){
                answer.add(cnt);
            }
        }

        return answer.stream().mapToInt(x->x).toArray();
    }
    public int[] solution2(int[] progresses, int[] speeds) {
        List<Integer> answer = new LinkedList<>();
        int idx = 0;
        int days = 0;
        while(idx<progresses.length){
            days++;
            int cnt = 0;
            if(progresses[idx]+days*speeds[idx]>=100){
                while(idx<progresses.length && progresses[idx]+days*speeds[idx]>=100){
                    cnt++;
                    idx++;
                }
            }

            if(cnt!=0){
                answer.add(cnt);
            }
        }

        return answer.stream().mapToInt(x->x).toArray();
    }



}
public class PG42586 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1,30,5};
        System.out.println(Arrays.toString(sol.solution(progresses,speeds)));

    }
}
