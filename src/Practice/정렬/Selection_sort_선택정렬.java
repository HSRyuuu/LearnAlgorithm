package Practice.정렬;

import java.util.Arrays;

public class Selection_sort_선택정렬 {

    private static void selectionSort(int[] arr) {
        int n = arr.length;

        for(int i = 0; i < n-1; i++){
            int maxIdx = 0;
            for (int j = i - 1; j >= 0 ; j--) {
                if(arr[j] > arr[maxIdx]){
                    maxIdx = j;
                }
            }
            swap(arr, i, maxIdx);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 7, 1, 4};
        selectionSort(arr);
        System.out.println("선택 정렬: " + Arrays.toString(arr));
    }
}
