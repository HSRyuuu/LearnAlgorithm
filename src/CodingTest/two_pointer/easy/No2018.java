package CodingTest.two_pointer.easy;
import java.util.Scanner;
/**
 * package : CodingTest.two_pointer
 * class name : No2018.java
 * date : 2023-06-23 오후 6:06
 * note : 수들의 합 5 / silver 5 / 투포인터
 */
public class No2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int start_index = 1;
        int end_index = 1;
        int sum = 1;
        int count = 1;

        while (end_index != n){
            if (sum == n) {
                count++;
                end_index++;
                sum+=end_index;
            }
            else if (sum > n) {
                sum -= start_index;
                start_index++;
            }
            else if (sum < n) {
                end_index++;
                sum += end_index;
            }
        }
        System.out.println(count);
    }
}
