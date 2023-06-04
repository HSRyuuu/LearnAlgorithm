package baekjoon.search.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1654 {
    // 1654번 : 랜선 자르기
    static int k;
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[k];

        long max = Long.MIN_VALUE;
        long min = 0;
        for(int i=0;i<k;i++){
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
            max = Math.max(n,max);
        }
        max++;
        while(min<max){
            long mid = (min+max)/2;
            long cnt = cutting(mid);

            if(cnt<n){
                max = mid;
            }else {
                min = mid+1;
            }
        }
        System.out.println(min-1);
    }
    static long cutting(long x){
        long result = 0;
        for(int i=0;i<arr.length;i++){
            result+=arr[i]/x;
        }
        return result;
    }
}
