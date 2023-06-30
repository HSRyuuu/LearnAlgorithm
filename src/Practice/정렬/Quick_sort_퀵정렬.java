package Practice.정렬;

import java.util.Arrays;

public class Quick_sort_퀵정렬 {
    public static void quickSort(int[] arr, int left, int right) {
        if(left >= right){
            return;
        }
        int pivot = partition(arr, left, right);

        quickSort(arr,left,pivot-1);//좌측
        quickSort(arr,pivot+1,right);//우측
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int start = left;
        int end = right;

        while(start<end){
            while(arr[end] > pivot && start<end){
                end--;
            }
            while(arr[start] <= pivot && start<end){
                start++;
            }
            swap(arr,start,end);
        }
        swap(arr,left,start);

        return start;
    }

    /**
     * quickSort2
     * 가운데 pivot 방식
     */
    public static void quickSort2(int[] arr, int start, int end){
        int part2 = partition2(arr, start, end);

        //왼쪽
        if(start < part2 - 1){
            quickSort2(arr, start, part2 - 1);
        }
        //오른쪽
        if(part2 < end){
            quickSort2(arr,part2, end);
        }

    }
    public static int partition2(int[] arr, int start, int end){
        int m = (start + end) / 2;
        int pivot = arr[m];

        while(start <= end){
            while(arr[start] < pivot){
                start ++;
            }
            while(arr[end] > pivot){
                end--;
            }
            if(start <= end){
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 7, 9, 4, 5, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("퀵 정렬1: " + Arrays.toString(arr));

        System.out.println("===============");

        int[] arr2 = {6, 2, 7, 9, 4, 5, 8};
        quickSort2(arr2, 0, arr2.length - 1);
        System.out.println("퀵 정렬2: " + Arrays.toString(arr2));
    }

}
