package CodingTest.data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * package : CodingTest.data_structure.stack
 * class name : No9935.java
 * date : 2023-06-23 오전 12:31
 * note : 문자열 폭발 / gold 4 / 스택, 문자열
 */
public class No9935 {
    static Stack<Character> stack;
    static String str;
    static String bomb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        str = br.readLine();
        bomb = br.readLine();

        stack = new Stack<>();
        for(int i = 0;i < str.length();i++){
            stack.push(str.charAt(i));

            if(stack.size() >= bomb.length()) {
                stackCheck();
            }
        }
        if(stack.size() >= bomb.length()) {
            stackCheck();
        }
        if(stack.isEmpty()){
            System.out.println("FRULA");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb.reverse());
    }
    public static void stackCheck(){
        boolean isEqual = true;
        for(int j = 0; j < bomb.length();j++){
            if(stack.get(stack.size()-bomb.length()+j) != bomb.charAt(j)){
                isEqual = false;
                break;
            }
        }
        if(isEqual){
            for(int j = 0; j < bomb.length();j++){
                stack.pop();
            }
        }
    }
}
