package CodingTest.greedy_algorithm.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * package : CodingTest.greedy_algorithm
 * class name : No11399.java
 * date : 2023-06-25 오후 1:45
 * note : ATM / silver 4 / 그리디
 */
public class No11399{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int waiting = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            waiting += arr[i];
            sum += waiting;
        }
        System.out.println(sum);
    }
}
