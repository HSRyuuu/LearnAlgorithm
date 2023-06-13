package CodingTest.greedy_algorithm;

import java.util.Scanner;

public class No11399_ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //사람 수
        int[] arr = new int[n]; //arr = [ 3 1 4 3 2 ]
        int[] sumArr = new int[n]; //합배열

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        //삽입 정렬
        for(int i=1; i<n; i++){
            int ins_point = i;
            int ins_value = arr[i];
            //j=i-1부터 0까지 돌면서 삽입 위치 찾기
            for(int j=i-1;j>=0;j--){
                if(arr[j]<ins_value){
                    ins_point = j+1;
                    break; //삽입 위치 찾으면 break
                }
                if(j==0){
                    ins_point=0;
                }
            }
            //삽입을 위해 삽입 위치에서 i까지의 데이터를 오른쪽으로 한칸씩 밀기
            for(int j=i;j>ins_point;j--){
                arr[j] = arr[j-1];
            }
            arr[ins_point] = ins_value;
        }//정렬 끝

        //합배열
        sumArr[0] = arr[0];
        for(int i=1;i<n;i++){
            sumArr[i] = sumArr[i-1]+arr[i];
        }

        int sum = 0;
        for (int i : sumArr) {
            sum+=i;
        }
        System.out.println(sum);


    }
}
