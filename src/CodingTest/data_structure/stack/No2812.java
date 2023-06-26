package CodingTest.data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * package : CodingTest.data_structure.stack
 * class name : No2812.java
 * date : 2023-06-26 오후 10:59
 * note : 크게 만들기 / gold 3 / 스택, 그리디
 */
public class No2812{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        Stack<Integer> stack = new Stack<>();

        int delCnt = 0;
        for(int i = 0 ; i < str.length(); i++){
            int x = Integer.parseInt(str.substring(i, i+1));
            if(stack.isEmpty()){
                stack.push(x);
                continue;
            }

            while(!stack.isEmpty() && stack.peek() < x && delCnt < K){
                stack.pop();
                delCnt++;
            }
            stack.push(x);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : stack) {
            sb.append(i);
        }

        String ans = sb.toString();
        if(delCnt < K ){
            ans = ans.substring(0, ans.length()-(K-delCnt));
        }
        System.out.println(ans);
    }
}
