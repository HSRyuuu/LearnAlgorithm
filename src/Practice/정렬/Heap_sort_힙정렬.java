package Practice.정렬;

import java.util.Arrays;

public class Heap_sort_힙정렬 {
    public static void heapSort(int[] arr) {
        //parentIdx는 arr.length/2 - 1까지만 가능
        for(int i = arr.length/2 - 1; i>=0;i--){
            heapify(arr,i, arr.length);
        }
        //max heap상태로 변경 / 정렬 x
        //루트노드는 최대값 상태
        for(int i = arr.length-1;i>0;i--){
            swap(arr,0,i); //최대값(0번 인덱스)와 맨 뒤의 인덱스를 swap
            heapify(arr,0,i);//맨 뒤(size-1)                                                                                       를 빼놓고 다시 heapify
        }

    }

    //heap 자료구조로 변경
    public static void heapify(int[] arr, int parentIdx, int size) {
        int leftIdx = 2 * parentIdx + 1; //왼쪽 : 부모 x2+1자리 / 오른쪽 : 부모x2+2자리
        int rightIdx = 2 * parentIdx + 2;
        int maxIdx = parentIdx;

        //parent, left, right중에 가장 큰걸 찾아서 maxIdx에 저장

        if(leftIdx < size && arr[maxIdx] < arr[leftIdx]){
            maxIdx = leftIdx;
        }
        if(rightIdx < size && arr[maxIdx] < arr[rightIdx]){
            maxIdx = rightIdx;
        }
        //maxIdx가 parent가 아니면 maxIdx랑 parent랑 자리 바꿔줌
        if(parentIdx != maxIdx){
            swap(arr, maxIdx, parentIdx);
            heapify(arr, maxIdx, size);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        heapSort(arr);
        System.out.println("힙 정렬: " + Arrays.toString(arr));
    }
}
