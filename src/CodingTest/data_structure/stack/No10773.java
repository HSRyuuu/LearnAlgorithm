package CodingTest.data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No10773 {
    // 10773번 : 제로
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<k;i++){
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                stack.pop();
            }else stack.push(n);
        }
        int count = 0;
        for(int num : stack){
            count+=num;
        }
        System.out.println(count);
    }
}
