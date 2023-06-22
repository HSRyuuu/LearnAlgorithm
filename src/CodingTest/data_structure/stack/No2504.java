package CodingTest.data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * package : CodingTest.data_structure.stack
 * class name : No2504.java
 * date : 2023-06-20 오후 4:26
 * note : 괄호의 값 / silver1 / stack
 */
public class No2504{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        String str = br.readLine();
        char[] arr = str.toCharArray();

        Stack<Character> stack = new Stack<>();
        boolean passFlag = true;
        int answer = 0;

        int value = 1;
        for (int i = 0; i < arr.length; i++) {
            char cur = arr[i];

            if(cur == '('){
                stack.push(cur);
                value*=2;
            }else if(cur == '['){
                stack.push(cur);
                value*=3;
            }else{
                if(cur == ')'){
                    if(stack.isEmpty() || stack.peek() != '('){
                        passFlag = false;
                        break;
                    }else if(arr[i-1] == '('){ // 현재의 value만큼 plus
                        answer += value;
                    }
                    stack.pop();
                    value /= 2; //괄호 하나가 완성되었으니 나누기2
                }
                else if(cur == ']'){
                    if(stack.isEmpty() || stack.peek() != '['){
                        passFlag = false;
                        break;
                    }else if(arr[i-1] == '['){ //현재의 value만큼 plus
                        answer += value;
                    }
                    stack.pop();
                    value /= 3; //괄호 하나가 완성되었으니 나누기 3
                }
                else{
                    passFlag = false;
                    break;
                }
            }
        }
        if(!passFlag || !stack.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(answer);
        }


    }

}