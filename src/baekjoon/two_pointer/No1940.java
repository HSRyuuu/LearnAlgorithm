package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1940 {
    // 1940번 : 주몽
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int front = 0;
        int end = n-1;
        int sum=0;
        int count=0;

        while(front<end){
            sum = arr[front] + arr[end];
            if(sum==m){
                count++;
                front++;
                end--;
            }
            else if(sum>m){
                end--;
            }
            else if(sum<m){
                front++;
            }
        }

        System.out.println(count);
    }
}
