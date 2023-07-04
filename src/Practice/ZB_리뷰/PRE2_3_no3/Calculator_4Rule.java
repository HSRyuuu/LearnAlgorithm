package Practice.ZB_리뷰.PRE2_3_no3;

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
        queue.offer(arr[0]); //첫번째 문자는 '-' 또는 숫자

        for(int i = 1; i < arr.length; i++){
            char ch = arr[i];
            if(ch == '+' || ch == '-'){
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
        if(queue.peek() == '-'){ //첫번째 문자가 '-' 일 때 result를 -1로 바꿔줌
            result = -1;
            queue.poll();
        }else if(queue.peek() == '+'){//첫번째 문자가 '+' 일 때
            queue.poll();
        }

        char last = '*'; // result = -1 또는 1이니까 맨처음 default를 *로 설정하면 있으나 마나임.
        while(!queue.isEmpty()){
            char peek = queue.peek();

            //연산자가 나온다면 이전까지의 결과를 계산하고, last에 해당 연산자를 저장해 줌.
            if(peek == '*' || peek == '/'){
                result = updateResult(sb.toString(), result, last);
                sb.setLength(0);
                last = peek;
            }
            else{
                sb.append(peek);
            }

            queue.poll();
        }
        //마지막에 남은 숫자를 계산해 줌.
        result = updateResult(sb.toString(), result, last);

        return result;
    }

    static double updateResult(String str, double result, char last){

        if(last == '*'){
            return result * Double.parseDouble(str);
        }else{
            return result / Double.parseDouble(str);
        }
    }

}

