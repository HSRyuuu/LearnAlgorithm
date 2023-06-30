package Practice.정렬;

import java.util.Arrays;
/**
 * 시간복잡도 O(n^2)
 *
 */
public class Bubble_sort_버블정렬 {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for(int i=1;i<n-1;i++) {
            for (int j = 0; j < n-i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 7, 1, 4};
        bubbleSort(arr);
        System.out.println("버블 정렬: " + Arrays.toString(arr));
    }
}
