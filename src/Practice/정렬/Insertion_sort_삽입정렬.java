package Practice.정렬;

import java.util.Arrays;

public class Insertion_sort_삽입정렬 {

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for(int i=1;i<n;i++){
            for (int j = i; j > 0; j--) {
                //i번인덱스부터 1까지 왼쪽과 비교해서 자기자신보다 크면 swap
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                }else break;
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
        insertionSort(arr);
        System.out.println("삽입 정렬: " + Arrays.toString(arr));
    }
}
