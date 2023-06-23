package CodingTest.two_pointer.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * package : CodingTest.two_pointer
 * class name : No1940.java
 * date : 2023-06-23 오후 6:05
 * note : 주몽 / silver 4 / 투포인터
 */
public class No1940{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));


        int N = Integer.parseInt(br.readLine()); // 재료의 개수
        int M = Integer.parseInt(br.readLine()); // 갑옷을 만드는데 필요한 수

        int[] arr = new int[N]; //재료 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        int cnt = 0;

        while(left < right){

            int sum = arr[left] + arr[right];

            if(sum == M){
                cnt++;
                left++;
                right--;
            }else if(sum > M){
                right--;
            }else{
                left++;
            }
        }
        System.out.println(cnt);
    }
}
