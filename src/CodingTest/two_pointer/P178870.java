package CodingTest.two_pointer;
/**
 * package : CodingTest.two_pointer.programmers
 * class name : P178870.java
 * date : 2023-06-24 오후 7:14
 * note : 연속된 부분 수열의 합 / lv2 / 투포인터
 * https://school.programmers.co.kr/learn/courses/30/lessons/178870
 */
public class P178870 {
    static class Solution {
        public int[] solution(int[] sequence, int k) {
            int[] result = new int[2];
            result[1] = sequence.length - 1;
            int left = 0;
            int right = 0;
            int sum = sequence[0];

            while(right < sequence.length){
                if(sum > k){
                    sum -= sequence[left++];
                }else if(sum < k ){
                    if(++right < sequence.length){
                        sum += sequence[right];
                    }
                }else{
                    if(right - left < result[1] - result[0]){
                        result[0] = left;
                        result[1] = right;
                    }
                    sum -= sequence[left++];
                }
            }

            return result;
        }
    }
    public static void main(String[] args) {

    }
}
