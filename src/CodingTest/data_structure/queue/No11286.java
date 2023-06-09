package CodingTest.data_structure.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * package : CodingTest.data_structure.queue
 * class name : No11286.java
 * date : 2023-06-22 오후 11:48
 * note : 절댓값 힙 / silver 1 / 큐
 */
public class No11286 {
    // 11286번 : 절댓값 힙
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int num1 = Math.abs((o1));
                int num2 = Math.abs((o2));

                if(num1==num2){
                    return o1>o2 ? 1:-1;
                }

                return num1-num2;

            }});
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            if(x!=0){
                queue.offer(x);
            }
            else{
                if(queue.isEmpty()){
                    sb.append("0\n");
                }
                else{
                    sb.append(queue.poll()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
