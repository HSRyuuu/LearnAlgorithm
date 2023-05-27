package programmers.math;

import java.util.Arrays;

/**
 * 분수의 덧셈
 * numer1 : 첫번째 분수의 분자
 * denom1 : 첫번째 분수의 분모
 * 두 분수를 더한 값을 기약분수로 나타내어라.
 * 분자 : answer[0], 분모 : answer[1]
 */
public class Math2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(1,2,3,4)));
        System.out.println(Arrays.toString(solution(9,2,1,3)));
    }
    public static int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int[] sum = new int[2];

        answer[1] = denom1*denom2;
        answer[0] = numer1*denom2 + numer2*denom1;
        for(int i=answer[1];i>=0;i--){
            if(answer[1]%i == 0 && answer[0]%i == 0){
                answer[1] = answer[1]/i;
                answer[0] = answer[0]/i;
                return answer;
            }
        }
        return answer;
    }
}
