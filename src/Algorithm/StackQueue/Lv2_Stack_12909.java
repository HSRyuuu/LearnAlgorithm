package Algorithm.StackQueue;

import java.io.IOException;
import java.util.Stack;

/**
 * @문제명: 올바른 괄호
 * @Tear: Lv2
 * @Algorithm: Stack
 * @Link: https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */
public class Lv2_Stack_12909 {

  public static void main(String[] args) throws IOException {
    String s = "()()";
    System.out.println("\" + s" + "\" => " + solution(s)); // true
    s = "(())()";
    System.out.println("\" + s" + "\" => " + solution(s)); //true
    s = ")()(";
    System.out.println("\" + s" + "\" => " + solution(s)); // false
    s = "(()(";
    System.out.println("\" + s" + "\" => " + solution(s)); // false
  }

  static boolean solution(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(') {
        stack.add(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        } else {
          stack.pop();
        }
      }
    }
    return stack.isEmpty();
  }
}
