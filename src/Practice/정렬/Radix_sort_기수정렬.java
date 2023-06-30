package Practice.정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [ 10 32 52 27 48 17 99 56 ]
 * 최대 자릿수만큼 반복
 * (1)
 *        52             17
 * 10     32          56 27 48 99
 *  0  1  2  3  4  5  6  7  8  9
 * => 10 32 52 56 27 17 48 99
 *
 * (2)
 *      17          56
 *      10 27 32 48 52          99
 *   0  1  2  3  4  5  6  7  8  9
 * => 10 17 27 32 48 52 56 99
 *
 *
 * 1. 일의자리 수가 같은 것끼리 모음
 * 2. 십의자리가 같은 것끼리 모음
 * ...
 *
 */
public class Radix_sort_기수정렬 {

    public static void radixSort(int[] arr) {
        ArrayList<Queue<Integer>> list = new ArrayList<>();

        // Queue 생성
        for (int i = 0; i < 10; i++) {
            list.add(new LinkedList<>());
        }

        int div = 1;
        int maxLen = getMaxLen(arr);

        for (int i = 0; i < maxLen; i++) {
            int idx = 0;
            //자릿수별로 넣음
            for (int j = 0; j < arr.length; j++) {
                list.get((arr[j] / div) % 10).offer(arr[j]);
            }

            for (int j = 0; j < 10; j++) {
                Queue<Integer> queue = list.get(j);

                while(!queue.isEmpty()){
                    arr[idx++] = queue.poll();
                }
                //큐에서 자릿수가 작은것부터 빼서 arr을 구성해줌
            }
            div *= 10;
        }

    }
    public static int getMaxLen(int[] arr){
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int len = (int)Math.log10(arr[i]) + 1;
            if(maxLen < len){
                maxLen = len;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        radixSort(arr);
        System.out.println("기수 정렬: " + Arrays.toString(arr));
    }
}
