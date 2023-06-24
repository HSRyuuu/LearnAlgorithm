package CodingTest.binary_search;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * package : CodingTest.search.binary_search
 * class name : No2110.java
 * date : 2023-06-22 오후 8:56
 * note : 공유기 설치 / gold 4 / 이분탐색
 */
public class No2110{
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //  N : 집의 개수
        int C = Integer.parseInt(st.nextToken()); //  C : 공유기 개수

        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int left = 1;
        int right = arr[arr.length-1]-arr[0]+1;
        //거리 중에 C개의 공유기를 설치할 수 있는 거리의 최대값
        while(left < right){
            int mid = left + (right - left) / 2;

            int cnt = 1;
            int lastLocate = arr[0];

            for(int i = 1 ; i < arr.length ; i++){
                if(arr[i] - lastLocate >= mid){
                    cnt ++;
                    lastLocate = arr[i];
                }
            }

            if(cnt < C){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        System.out.println(left - 1);
    }
}

