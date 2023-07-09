package Practice.정렬;

import java.util.*;

/**
 * 1. 배열에서 가장 큰 값을 찾아서 최대값 저장
 * 2. 배열을 돌며 각 값들에 해당되는 카운팅 배열의 인덱스에 + 1
 * 3. 카운팅 배열에서 맨 앞에서부터 숫자가 0이 아닌것들을 결과 배열에 담아줌
 */
public class Counting_sort_카운팅정렬 { // 계수 정렬

    public static List<Integer> countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] cntArr = new int[max + 1];

        //배열을 순회하며 각 데이터값과 동일한 인덱스의 데이터를 1씩 증가시킨다.
        for (int i = 0; i < arr.length; i++) {
            cntArr[arr[i]]++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < cntArr.length; i++) {
            if(cntArr[i] == 0){
                continue;
            }
            for (int j = 0; j < cntArr[i]; j++) {
                result.add(i);
            }
        }
        return result;
    }
    public static List<Integer> countingSort2(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : arr){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            for (int j = 0; j < map.get(num); j++) {
                result.add(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 4, 1, 1, 2, 4, 3, 3, 6, 5};
        System.out.println(countingSort2(arr));
    }
}
