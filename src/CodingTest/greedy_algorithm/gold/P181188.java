package CodingTest.greedy_algorithm.gold;

import java.util.Arrays;
/**
 * package : CodingTest.greedy_algorithm.gold
 * class name : P181188.java
 * date : 2023-06-25 오후 11:53
 * note : 요격 시스템 / lv2 / 그리디
 */
public class P181188 {
    public static void main(String[] args) {
        
    }
    static class Solution {
        public int solution(int[][] targets) {
            int answer = 0;
            Arrays.sort(targets, (o1, o2) ->  o1[1]-o2[1]);

            double last = -1;
            for(int[] cur : targets){
                if(last == -1){
                    last = cur[1] - 0.5;
                    answer++;
                    continue;
                }
                if(last > cur[0] && last < cur[1] ){
                    continue;
                }else{
                    last = cur[1]-0.5;
                    answer++;
                }
            }
            return answer;
        }
    }
}
