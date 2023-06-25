package CodingTest.greedy_algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * package : CodingTest.greedy_algorithm
 * class name : No2437.java
 * date : 2023-06-25 오후 3:21
 * note : 저울 / gold 2 / 그리디
 */
public class No2437{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(sum + 1 < arr[i]){
                break;
            }
            sum += arr[i];
        }
        System.out.println(sum + 1);

    }
}
