package Practice.프로그래머스리뷰.PRE2_3_no3;

import java.util.*;

/**
 * pre 코테 2주차 2-3 3번
 * 사칙연산 계산기
 *
 * 문자열 S는 숫자와 사칙연산 기호(+, -, *, /)로 이루어진 수식입니다.
 * 해당 수식을 사칙연산 계산 순서에 맞춰 계산하는 프로그램을 작성하세요.
 * 단, 결과는 소수점 자리는 2번째 자리까지 표현합니다.
 * 즉, 소수점 자리 3번째 자리에서 내림하여 실수(double) 형식으로 출력하세요.
 *
 * 입력 형식
 * S: 숫자와 사칙연산으로 이루어진 문자열
 *
 * 출력 형식
 * S 수식을 계산한 결과를 double로 반환
 *
 * 제약 사항
 * 1 <= S <= 100
 */
public class Calculator_4Rule {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "2*3+5/6*3+15";
        System.out.println(sol.solution(s1));

        String s2 = "10/3";
        System.out.println(sol.solution(s2));
    }
}

class Solution {
    public double solution(String S) {
        double answer = 0;
        char[] arr = S.toCharArray();

        Queue<Character> queue = new LinkedList<>();

        for(int i = 0; i < arr.length; i++){
            char ch = arr[i];

            if(ch == '+' || ch == '-' && i != 0){
                answer += calc(queue);
            }
            queue.offer(ch);
        }

        answer += calc(queue);
        answer = Math.floor(answer * 100) / 100;

        return answer;
    }

    static double calc(Queue<Character> queue){
        StringBuilder sb = new StringBuilder();
        double result = 1;

        //첫번째 문자('+'' or '-' or 숫자) 확인
        if(queue.peek() == '-'){
            result = -1;
            queue.poll();
        }else if(queue.peek() == '+'){
            queue.poll();
        }

        char last = '*';
        while(!queue.isEmpty()){
            char peek = queue.peek();

            if(peek == '*' || peek == '/'){
                result = updateResult(sb, result, last);
                last = peek;
            }
            else{
                sb.append(peek);
            }

            queue.poll();
        }

        result = updateResult(sb, result, last);

        return result;
    }

    static double updateResult(StringBuilder sb, double result, char last){
        String str = sb.toString();
        sb.setLength(0);

        if(last == '*'){
            return result * Double.parseDouble(str);
        }else{
            return result / Double.parseDouble(str);
        }
    }

}

