package CodingTest.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;



/** 백준 11004
 * 퀵 정렬
 */
public class No11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(arr,0,n-1);
        System.out.println(arr[k-1]);

    }
    public static void quickSort(int[] arr, int start, int end){
        int part2 = partition(arr,start,end); // 오른쪽 파티션의 시작점
        if(start < part2-1){
            quickSort(arr,start,part2-1);
        }
        if(part2<end){
            quickSort(arr,part2,end);
        }
    }
    public static int partition(int[] arr, int start, int end) {
        int m = (start+end)/2;
        int pivot = arr[m]; // 피봇 : 해당 파티션의 중간에 있는 값
        while(start<=end){
            while(arr[start] < pivot)start++; // start가 피봇보다 작으면 start++ (피봇보다 큰 값이 나올때까지 반복)
            while(arr[end] > pivot)end--; //end가 피봇보다 크면 end-- (피봇보다 작은 값이 나올때까지 반복

            //start와 end가 서로 엇갈리지 않았으면 swap
            if(start <= end){
                swap(arr,start,end);
                start++;
                end--;
            }
        }//start와 end가 엇갈릴때까지 반복
        return start; //새로 나뉠 파티션의 첫번째 인덱스를 반환 (part2)
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
