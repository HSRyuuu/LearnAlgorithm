package Practice.정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * 1. 배열에서 가장 큰 값을 찾아서 최대값 저장
 * 2. 배열을 돌며 각 값들에 해당되는 카운팅 배열의 인덱스에 + 1
 * 3. 카운팅 배열에서 맨 앞에서부터 숫자가 0이 아닌것들을 결과 배열에 담아줌
 */
public class Counting_sort_카운팅정렬 { // 계수 정렬

    public static void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] cntArr = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            cntArr[arr[i]]++;
        }

        int idx = 0;
        for (int i = 0; i < cntArr.length; i++) {
            while(cntArr[i] > 0){
                arr[idx++] = i;
                cntArr[i] -= 1;
            }
        }
    }
    public static void countingSort2(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int item : arr){
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        int idx = 0;
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            int cnt = map.get(list.get(i));
            while(cnt > 0){
                arr[idx++] = list.get(i);
                cnt--;
            }

        }
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {10, 32, 10, 27, 32, 17, 99, 56};
        countingSort(arr);
        System.out.println("계수 정렬: " + Arrays.toString(arr));
    }
}
