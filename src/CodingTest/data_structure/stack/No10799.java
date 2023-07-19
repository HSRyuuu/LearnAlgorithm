package CodingTest.data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * package : CodingTest.data_structure.stack
 * class name : No10799.java
 * date : 2023-07-19 오후 10:05
 * info : 쇠막대기 / silver 2 / 스택
 * link : https://www.acmicpc.net/problem/10799
 */
public class No10799{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        char[] arr = br.readLine().toCharArray();

        Stack<Integer> stack = new Stack<>();
        int cnt = 0;

        for(int i = 0; i < arr.length;i++){
            if(i != arr.length-1 && arr[i] == '(' && arr[i+1] == ')'){
                cnt += stack.size();
                i++;
                continue;
            }
            if(arr[i] == '('){
                stack.push(i);
            }else{
                cnt++;
                stack.pop();
            }
        }
        System.out.println(cnt);
    }
}
