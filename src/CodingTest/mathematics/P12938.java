package CodingTest.mathematics;

import java.util.*;

/**
 * package : CodingTest.mathematics
 * class name : P12938.java
 * date : 2023-07-15 오후 9:27
 * info : 수학 / lv 3 / 최고의 집합
 * link : https://school.programmers.co.kr/learn/courses/30/lessons/12938
 */
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(s < n){
            return new int[]{-1};
        }
        int mod = s%n;
        Arrays.fill(answer, s/n);
        for(int i = answer.length-1; i >= answer.length-mod; i--){
            answer[i]++;
        }

        return answer;
    }
}
public class P12938 {
}
