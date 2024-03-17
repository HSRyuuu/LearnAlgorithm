package CodingTest.data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * package : CodingTest.data_structure.stack
 * class name : G5_No2493.java
 * date : 2024-03-18 오전 12:06
 * info : 탑 / Gold 5 / Stack
 * link :
 */
public class G5_No2493 {

    static class Tower{
        int height;
        int loc;
        public Tower(int height, int loc){
            this.height = height;
            this.loc = loc;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        StringJoiner sj = new StringJoiner(" ");
        Stack<Tower> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());//타워 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            Tower cur = new Tower(Integer.parseInt(st.nextToken()), i + 1);

            while(true){
                if(stack.isEmpty()){
                    sj.add("0");
                    stack.push(cur);
                    break;
                }

                Tower peek = stack.peek();
                if(peek.height > cur.height){
                    sj.add(Integer.toString(peek.loc));
                    stack.push(cur);
                    break;
                }
                stack.pop();
            }
        }

        System.out.println(sj);
    }
}