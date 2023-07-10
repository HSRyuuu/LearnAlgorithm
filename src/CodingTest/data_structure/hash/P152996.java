package CodingTest.data_structure.hash;

import java.util.*;

/**
 * package : CodingTest.data_structure.hash
 * class name : P152996.java
 * date : 2023-07-10 오후 11:24
 * info : 시소 짝꿍 / lv2 / 해시, 구현
 * link : https://school.programmers.co.kr/learn/courses/30/lessons/152996
 */
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);

        Map<Double, Integer> map = new HashMap<>();

        for(int x : weights){
            double a = (double)x;
            double b = (double)x * 2 / 3;
            double c = (double)x * 2 / 4;
            double d = (double)x * 3 / 4;
            if(map.containsKey(a)){
                answer += map.get(a);
            }
            if(map.containsKey(b)){
                answer += map.get(b);
            }
            if(map.containsKey(c)){
                answer += map.get(c);
            }
            if(map.containsKey(d)){
                answer += map.get(d);
            }
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        return answer;
    }
}

public class P152996 {
}
