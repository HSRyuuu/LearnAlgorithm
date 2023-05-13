package baekjoon.search.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2343 {
    //2343번 : 기타 레슨
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //레슨의 수
        int m = Integer.parseInt(st.nextToken()); //블루레이 수
        int[] arr = new int[n];

        int start = 0;
        int end = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > start) start = arr[i];
            end += arr[i];
        }
        //--------여기까지 입력-----------

        while (start <= end) {
            // 9 26
            int mid = (start + end) / 2; //17
            int sum = 0;
            int count = 0;
            for(int i=0;i<n;i++) {
                sum +=arr[i];
                if (sum > mid) {
                    count++;
                    sum = arr[i];
                }
            }
            if(sum!=0){
                count++;
            }

            if(count>m){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        System.out.println(start);
    }
}
