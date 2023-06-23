package CodingTest.two_pointer.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * package : CodingTest.two_pointer
 * class name : No2003.java
 * date : 2023-06-23 오후 5:58
 * note : 수들의 합 2 / silver 4
 */
public class No2003{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수열 길이
        int M = Integer.parseInt(st.nextToken()); // 수열의 합의목표

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;

        int sum = 0;
        int cnt = 0;

        while(true){

            if(sum > M){
                sum -= arr[left++];
            }else if(right >= arr.length){
                break;
            }else{
                sum += arr[right++];
            }
            if(sum == M){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
