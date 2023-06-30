package CodingTest.data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * package : CodingTest.data_structure.stack
 * class name : No17298.java
 * date : 2023-06-29 오후 10:08
 * info : 오큰수 / gold 4 / 스택
 * link : https://www.acmicpc.net/problem/17298
 * https://school.programmers.co.kr/learn/courses/30/lessons/154539 -> 비슷한 문제
 */
public class No17298 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++){
            int x = arr[i];
            while(!stack.isEmpty() && arr[stack.peek()] < x){
                arr[stack.pop()] = x;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
