package Practice.정렬;

import java.util.Arrays;

/**
 * 삽입정렬의 약점을 보완한 정렬 방식
 * gap은 arr길이 / 2 부터 시작해서 2씩 나누면서 반복
 */
public class Shell_sort_셸정렬 {
    public static void shellSort(int[] arr) {
        int gap = arr.length / 2;

        for (int g = gap; g > 0; g /= 2) {

            for (int i = g; i < arr.length; i++) {
                int tmp = arr[i];

                int j = 0;
                for(j = i-g;j >= 0 ; j-=g){
                    if(arr[j] > tmp){
                        arr[j+g] = arr[j];
                    }else{
                        break;
                    }
                }
                arr[j+g] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        shellSort(arr);
        System.out.println("셸 정렬: " + Arrays.toString(arr));
    }
}
