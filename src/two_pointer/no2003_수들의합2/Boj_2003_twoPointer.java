package two_pointer.no2003_수들의합2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2003_twoPointer {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(twoPointer(arr,m));

    }
    static int twoPointer(int[] arr, int m){

        int start = 0;
        int end = 0;
        int count=0;
        int len = arr.length;
        int sum = 0;

        while(true){
            if(sum>=m){
                sum-=arr[start++];
            }
            else if(end>=len)break;
            else sum+=arr[end++];

            if(sum==m)count++;
        }
        return count;
    }
}