package CodingTest.data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringJoiner;

/**
 * package : CodingTest.data_structure.stack
 * class name : S2_No1874.java
 * date : 2024-03-17 오후 11:52
 * info : 스택 수열 / Silver2 / Stack
 * link :
 */
public class S2_No1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());

        StringJoiner sj = new StringJoiner("\n");

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int last = Integer.parseInt(br.readLine());
        //첫번째 수까지
        for(int i = 1; i <= last; i++){
            stack.push(i);
            sj.add("+");
        }
        sj.add("-");
        stack.pop();

        for(int i = 1; i < n; i++){
            int cur = Integer.parseInt(br.readLine());

            if(stack.peek() == cur){
                stack.pop();
                sj.add("-");
                continue;
            }
            if(cur < last)break;

            for(int j = last + 1; j <= cur; j++){
                stack.push(j);
                last = j;
                sj.add("+");
            }
            stack.pop();
            sj.add("-");
        }

        if(stack.size() == 1){
            System.out.println(sj);
        }else{
            System.out.println("NO");
        }
    }
}