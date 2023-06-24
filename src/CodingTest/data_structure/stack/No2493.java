package CodingTest.data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * package : CodingTest.data_structure.stack
 * class name : No2493.java
 * date : 2023-06-24 오후 12:50
 * note : 탑 / gold 5 / 스택
 */

public class No2493 {
    static class Tower {
        int h;
        int num;

        public Tower(int h, int num) {
            this.h = h;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine()); //탑의 개수

        Stack<Tower> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Tower cur = new Tower(Integer.parseInt(st.nextToken()), i+1);
            if(stack.isEmpty()){
                sb.append(0+" ");
                stack.push(cur);
                continue;
            }
            //스택이 비어있거나, cur보다 큰 값을 찾았을 때 출력하고 while문 종료
            while(true){
                if(stack.isEmpty()){
                    sb.append(0+" ");
                    stack.push(cur);
                    break;
                }
                Tower peek = stack.peek();
                //cur보다 큰 값을 찾으면 출력하고, 현재 값을 stack에 넣고 종료
                if(peek.h > cur.h){
                    sb.append(peek.num+" ");
                    stack.push(cur);
                    break;
                }else{
                    //cur보다 작은 값이면 이후에도 쓸모없는 값이기 때문에 pop()
                    stack.pop();
                }
            }
        }
        System.out.println(sb);
    }
}
