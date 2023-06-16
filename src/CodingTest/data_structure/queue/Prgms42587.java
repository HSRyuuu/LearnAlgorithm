package CodingTest.data_structure.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * package : CodingTest.data_structure.queue
 * class name : Prgms42587.java
 * date : 2023-06-16 오후 1:55
 * note : 프로세스 / lv2 / 큐
 */
class Process{
    int priority;
    boolean isTarget;
    public Process(int priority,boolean isTarget){
        this.priority = priority;
        this.isTarget = isTarget;
    }

    @Override
    public String toString() {
        return "["+priority+" "+isTarget+"]";
    }
}
class Solution42587 {

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            if (i != location) {
                queue.offer(new Process(priorities[i], false));
            } else {
                queue.offer(new Process(priorities[i], true));
            }
        }
        System.out.println(queue);
        int cnt = 1;
        while (!queue.isEmpty()) {
            Process cur = queue.poll();
            boolean isPossible = true;

            for (Process p : queue) {
                if (p.priority > cur.priority) {
                    isPossible = false;
                    break;
                }
            }
            if (!isPossible) {
                queue.offer(cur);
            } else if (isPossible && cur.isTarget) {
                answer = cnt;
                break;
            } else {
                cnt++;
            }
        }
        return answer;
    }
}
public class Prgms42587{
    public static void main(String[] args) {
        Solution42587 sol = new Solution42587();
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(sol.solution(priorities, location));

        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        location = 0;
        System.out.println(sol.solution(priorities2, location));


    }

}