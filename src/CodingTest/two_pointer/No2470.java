package CodingTest.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * package : CodingTest.two_pointer
 * class name : No2470.java
 * date : 2023-07-05 오전 12:34
 * info : 두 용액 / gold 5 / 투포인터
 * link : https://www.acmicpc.net/problem/2470
 */
public class No2470{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length-1;
        int[] data = new int[2]; //왼쪽 값, 오른쪽 값
        int min = Integer.MAX_VALUE;

        // -99 -2 -1 4 98
        while(left < right){
            int sum = arr[left] + arr[right];
            int abs =  Math.abs(sum);

            if(abs < min){
                min = abs;
                data[0] = arr[left];
                data[1] = arr[right];
                if(sum == 0){
                    break;
                }
            }
            if(sum > 0){
                right--;
            }else{
                left++;
            }

        }
        System.out.println(data[0]+" "+data[1]);
    }
}