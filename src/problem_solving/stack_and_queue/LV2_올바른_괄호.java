package problem_solving.stack_and_queue;

import java.util.Stack;

import static common.Grader.grade;

/**
 * @문제명: 올바른 괄호
 * @Tear: Lv2
 * @Algorithm: Stack
 * @Link: https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */
public class LV2_올바른_괄호 {

    public static void main(String[] args) {

        // situation1: 연속된 올바른 괄호
        String input1 = "()()";
        boolean expected1 = true;
        boolean result1 = solution(input1);
        grade(1, "연속된 올바른 괄호 ()()", expected1, result1);

        // situation2: 중첩 + 연속 괄호
        String input2 = "(())()";
        boolean expected2 = true;
        boolean result2 = solution(input2);
        grade(2, "중첩 + 연속 괄호 (())()", expected2, result2);

        // situation3: 엣지 케이스 - 닫는 괄호로 시작
        String input3 = ")()(";
        boolean expected3 = false;
        boolean result3 = solution(input3);
        grade(3, "닫는 괄호로 시작 )()(", expected3, result3);

        // situation4: 엣지 케이스 - 여는 괄호가 더 많음
        String input4 = "(()(";
        boolean expected4 = false;
        boolean result4 = solution(input4);
        grade(4, "여는 괄호가 더 많음 (()(", expected4, result4);

        // situation5: 엣지 케이스 - 빈 문자열에 가까운 최소 입력
        String input5 = "()";
        boolean expected5 = true;
        boolean result5 = solution(input5);
        grade(5, "최소 올바른 괄호 ()", expected5, result5);

        // situation6: 엣지 케이스 - 닫는 괄호만 있음
        String input6 = "))";
        boolean expected6 = false;
        boolean result6 = solution(input6);
        grade(6, "닫는 괄호만 있음 ))", expected6, result6);
    }

    /**
     * TODO: 이 메서드를 구현하세요!
     *
     * @param s '(' 또는 ')'로만 이루어진 문자열
     * @return 올바른 괄호이면 true, 아니면 false
     */
    static boolean solution(String s) {
        // hint: 스택을 활용하여 여는 괄호를 push, 닫는 괄호를 만나면 pop
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != '(' && c != ')') {
                System.out.println("input always '(' or ')'");
                return false;
            }
            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (!stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }

        }

        return stack.isEmpty();
    }
}
