package baekjoon.search.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1654 {
    // 1654번 : 랜선 자르기
    static int ans;
    static int k;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        for(int i=0;i<k;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int min = 0;
        int max = arr[k-1]++;
        int mid = 0;

        while(min<max){
            int count = 0;
            mid = (max+min)/2;
            for (int i=0;i<k;i++){
                count+=(arr[i]/mid);
            }
            if(count<n){
                max = mid;
            }else{
                min = mid+1;
            }
        }
        System.out.println(min-1);


    }
}
