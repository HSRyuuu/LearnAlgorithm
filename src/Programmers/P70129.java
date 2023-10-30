package Programmers;

/**
 * package : Programmers
 * class : P70129
 * date : 2023-10-30 오후 4:20
 * info :
 * link : https://school.programmers.co.kr/learn/courses/30/lessons/70129?language=java
 */
public class P70129 {
}
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while(!s.equals("1")){
            answer[1] += zeroCount(s);

            //0 삭제
            s = deleteZero(s);

            int length = s.length();

            //이진수로 변환
            s = Integer.toString(length, 2);

            answer[0] += 1;
        }

        return answer;
    }

    static String deleteZero(String s){
        return s.replaceAll("0", "");
    }

    static int zeroCount(String s){
        int cnt = 0;
        for(char ch : s.toCharArray()){
            if(ch == '0'){
                cnt++;
            }
        }
        return cnt;
    }
}
