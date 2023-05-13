package baekjoon.greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class No1931 {
    // 1931번 : 회의실배정
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //[][0] : 시작시간 , [][1] : 종료시간
        int[][] arr = new int[n][2];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        //종료시간이 빠른 순으로 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //종료시간이 같으면 시작시간이 빠른 순으로 정렬
                if(o1[1]==o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int count=0;
        int lastEndTime = 0;
        //시작시간이 지난 종료시간보다 크거나 같으면 갱신한다.
        for(int i=0;i<n;i++){
            if(lastEndTime<=arr[i][0]){
                lastEndTime = arr[i][1];
                count++;
            }
        }
        System.out.println(count);

    }
}
