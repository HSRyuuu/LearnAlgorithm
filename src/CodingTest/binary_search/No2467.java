package CodingTest.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * package : CodingTest.binary_search
 * class name : No2467.java
 * date : 2023-07-22 오후 11:31
 * info : 용액 / gold 5 / 이진탐색
 * link : https://www.acmicpc.net/problem/2467
 */
public class No2467{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long min = Long.MAX_VALUE;
        int minL = 0, minR = 0;
        for(int i = 0 ; i < N - 1; i++){
            int cur = arr[i];
            int left = i + 1;
            int right = N - 1;

            while(left <= right){
                int mid = (left + right)/2;
                long sum = Math.abs(cur + arr[mid]);

                if(min > sum){
                    min = sum;
                    minL = cur;
                    minR = arr[mid];
                }
                if(arr[mid] >= -cur){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        System.out.println(minL + " " + minR);
    }
}
