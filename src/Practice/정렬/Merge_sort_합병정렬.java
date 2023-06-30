package Practice.정렬;

import java.util.Arrays;

public class Merge_sort_합병정렬 {
    public static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if(left<right){
            int mid = (left+right)/2; //중앙값
            mergeSort(arr, tmp, left, mid); //좌측
            mergeSort(arr, tmp,mid+1, right);//우측
            merge(arr, tmp, left, right, mid);
        }
    }

    public static void merge(int[] arr, int[] tmp, int left, int right, int mid) {
        int p = left;
        int q = mid + 1;
        int idx = p;

        while(p <= mid || q <= right){
            if( p <= mid && q<=right){
                //p, q중에 작은 값을 idx에 넣는다. p를 넣었으면 p++, q를 넣었으면 q++
                if(arr[p] <= arr[q]){
                    tmp[idx++] = arr[p++];
                }else{
                    tmp[idx++] = arr[q++];
                }
            }
            else if(p <= mid && q > right){//좌측만 남았을 때는 p를 넣는다.
                tmp[idx++] = arr[p++];
            }
            else{ //우측만 남아을 때는 q를 넣는다.
                tmp[idx++] = arr[q++];
            }
        }//while문 종료

        for(int i = left; i<= right; i++){
            arr[i] = tmp[i];
        }
    }


    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
        System.out.println("합병 정렬: " + Arrays.toString(arr));
    }
}
