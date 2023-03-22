package data_structure.stack_and_queue.no1874_stack;

import java.util.Scanner;
import java.util.Stack;

public class Boj_1874_stack {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int n = sc.nextInt();

        int m = sc.nextInt();
        int last = m;
        for(int i=1;i<=m;i++){
            stack.push(i);
            printPush();
        }
        stack.pop();
        printPop();

        for(int i=0;i<n-1;i++){
            int x = sc.nextInt();

            if(stack.peek()==x){
                stack.pop();
                printPop();
            }else {
                if(x<last)break;
                for (int j = last+1; j <= x; j++) {
                    stack.push(j);
                    last = j;
                    printPush();
                }
                stack.pop();
                printPop();
            }
        }
        if(stack.size()==1){
            System.out.println(sb);
        }
        else System.out.println("NO");

    }
    public static void printPush(){
        sb.append('+').append("\n");
    }
    public static void printPop(){
        sb.append('-').append("\n");
    }

}
