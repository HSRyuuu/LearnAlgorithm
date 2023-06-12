package baekjoon.data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 2493번 : 탑
 * gold 5
 */
public class No2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>(); //int[0] : 높이 , int[1] : 탑 번호
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            int cur = Integer.parseInt(st.nextToken()); // i : 타워 번호
            if(stack.isEmpty()){
                sb.append("0 ");
                stack.push(new int[]{cur,i});
                continue;
            }
            //스택이 비어있거나, cur보다 큰 값을 찾았을 때 출력하고 while문 종료
            while(true){
                if(stack.isEmpty()){
                    sb.append("0 ");
                    stack.push(new int[]{cur,i});
                    break;
                }
                int[] peek = stack.peek();
                //cur보다 큰 값을 찾으면 출력하고, 현재 값을 stack에 넣고 종료
                if(peek[0]>cur){
                    sb.append(peek[1]+" ");
                    stack.push(new int[]{cur,i});
                    break;
                }else{//cur보다 작은 값이면 이후에도 쓸모없는 값이기 때문에 pop()
                    stack.pop();
                }
            }
        }
        System.out.println(sb);
    }
}
