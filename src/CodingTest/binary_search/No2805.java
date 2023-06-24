package CodingTest.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * package : CodingTest.search.binary_search
 * class name : No2805.java
 * date : 2023-06-22 오후 4:32
 * note : 나무 자르기 / silver 2 / 이분탐색
 */
public class No2805{
    static int[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //나무의 수
        int target = Integer.parseInt(st.nextToken()); //나무의 길이
        trees = new int[n];

        st = new StringTokenizer(br.readLine());

        int max = 0;
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(trees[i], max);
        }

        int left = 0;
        int right = max;
        while(left < right){
            int mid = (left + right) / 2;
            long sum = cutting(mid);

            if(sum < target){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        System.out.println(left-1);
    }
    static long cutting(int cutPoint){
        long total = 0;
        for(int tree : trees){
            if(tree > cutPoint){
                total += tree - cutPoint;
            }
        }
        return total;
    }

}