package CodingTest.greedy_algorithm.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * package : CodingTest.greedy_algorithm.gold
 * class name : No1744.java
 * date : 2023-06-26 오전 11:16
 * note : 수 묶기 / gold 4 / 그리디
 */
public class No1744{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        PriorityQueue<Integer> pqMinus = new PriorityQueue<>();
        PriorityQueue<Integer> pqPlus = new PriorityQueue<>((o1,o2) -> o2-o1);

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x>0){
                pqPlus.offer(x);
            }else{
                pqMinus.offer(x);
            }
        }
        int ans = 0;

        if(pqPlus.size() == 2){
            int num1 = pqPlus.poll();
            int num2 = pqPlus.poll();
            ans += num1*num2 > num1+num2 ? num1*num2 : num1+num2;
        }

        while(!pqPlus.isEmpty()){
            if(pqPlus.size() == 1){
                break;
            }
            int num1 = pqPlus.poll();
            int num2 = pqPlus.poll();

            if(num1*num2 > num1 + num2){
                ans += num1*num2;
            }else{
                ans += num1 + num2;
            }
        }

        if(!pqPlus.isEmpty()){
            ans += pqPlus.poll();
        }

        while(!pqMinus.isEmpty()){
            if(pqMinus.size() == 1){
                break;
            }
            ans += pqMinus.poll() * pqMinus.poll();
        }

        if(!pqMinus.isEmpty()){
            ans += pqMinus.poll();
        }

        System.out.println(ans);
    }
}
