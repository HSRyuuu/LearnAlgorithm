package CodingTest.data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 포스택
 * gold5
 */
public class No25556_G5 {
    public static void main(String[] args) throws IOException {
        String answer = "";
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());

        //스택 초기화
        Stack<Integer>[] stacks = new Stack[4];
        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new Stack<>();
            stacks[i].add(-1); //더미 데이터
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int cur = Integer.parseInt(st.nextToken());
            boolean isPushed = false;
            for (Stack<Integer> stack : stacks) {
                if(stack.peek() < cur){
                    stack.push(cur);
                    isPushed = true;
                    break;
                }
            }
            if(!isPushed){
                answer = "NO";
                break;
            }
        }
        if(!answer.equals("NO")){
            answer = "YES";
        }
        System.out.println(answer);
    }
}
