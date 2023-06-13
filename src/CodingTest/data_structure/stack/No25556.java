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
public class No25556 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer>[] arr = new Stack[4];
        for(int i=0;i<4;i++){
            arr[i] = new Stack<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0].add(Integer.parseInt(st.nextToken()));

        for(int i=1;i<n;i++){
            int x =Integer.parseInt(st.nextToken());
            boolean insert = false;

            for (Stack<Integer> stack : arr) {
                if(!stack.isEmpty()){
                    if(stack.peek()<x){
                        stack.push(x);
                        insert = true;
                        break;
                    }
                }else{
                    stack.push(x);
                    insert = true;
                    break;
                }
            }
            if(!insert){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
