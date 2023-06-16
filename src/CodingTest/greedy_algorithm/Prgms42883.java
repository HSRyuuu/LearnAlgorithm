package CodingTest.greedy_algorithm;

import java.util.*;
/**
 * package : CodingTest.greedy_algorithm
 * class name : Prgms42883.java
 * date : 2023-06-16 오전 11:18
 * note : 큰 수 만들기 / 그리디
 * https://school.programmers.co.kr/learn/courses/30/lessons/42883
 */

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        String[] arr = number.split("");

        Stack<Integer> stack = new Stack<>();
        int delCnt = 0;
        for(int i=0;i<arr.length;i++){
            int num = Integer.parseInt(arr[i]);
            while(!stack.isEmpty() && stack.peek()<num && delCnt<k){
                stack.pop();
                delCnt++;
            }
            stack.push(num);
        }
        StringBuilder sb = new StringBuilder();
        if(delCnt<k){
            for(int i=0;i<k-delCnt;i++){
                stack.pop();
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
