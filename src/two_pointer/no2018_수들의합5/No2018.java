package two_pointer.no2018_수들의합5;
import java.util.Scanner;
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
