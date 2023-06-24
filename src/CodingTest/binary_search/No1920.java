package CodingTest.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * package : CodingTest.search.binary_search
 * class name : No1920.java
 * date : 2023-06-22 오후 5:06
 * note : 원하는 정수 찾기 / silver 4 / 이분탐색
 */
public class No1920 {
    //1920번 :

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int num = Integer.parseInt(st.nextToken());
            sb.append(find(num)).append("\n");
        }
        System.out.println(sb);
    }

    private static int find(int num) {
        int start = 0;
        int end = arr.length-1;


        while(start<=end){
            int mid = (start+end)/2;

            if(num>arr[mid]){
                start = mid+1;
            }else if(num<arr[mid]){
                end = mid-1;
            }else if(num == arr[mid]){
                return 1;
            }
        }
        return 0;
    }

}
