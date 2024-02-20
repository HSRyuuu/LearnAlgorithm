package CodingTest.data_structure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * package : baekjoon.data_structure.deque
 * class name : No1021.java
 * date : 2023-06-13 오후 2:31
 * note : 회전하는 큐 / silver3 / deque
 */
public class No1021 {

    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());//크기
        int M = Integer.parseInt(st.nextToken());//수의 개수
        st = new StringTokenizer(br.readLine());

        queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        int result = 0;
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            result += findFirst(target);
        }
        System.out.println(result);
    }

    static int findFirst(int target) {
        int listSize = queue.size();
        int count = 0;
        while (true) {
            int find = queue.poll();
            if (target == find) {
                break;
            }
            queue.offer(find);
            count++;
        }
        if (listSize / 2 < count) {
            return listSize - count;
        }
        return count;
    }

}
