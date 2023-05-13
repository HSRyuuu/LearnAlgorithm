package baekjoon.data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No4949 {
    // 4949번 : 균형잡힌 세상
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;
            System.out.println(answer(str));
        }
    }
    public static String answer(String str){
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            if(ch=='('||ch=='['){
                stack.push(ch);
            }
            else if(ch==')'){
                if(stack.isEmpty()||stack.peek()!='('){
                    return "no";
                }
                else stack.pop();
            }
            else if(ch==']'){
                if(stack.isEmpty()||stack.peek()!='['){
                    return "no";
                }
                else stack.pop();
            }

        }
        if(stack.isEmpty()){
            return "yes";
        }else return "no";
    }

}
