package CodingTest.data_structure.priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class G4_No1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pqPlus = new PriorityQueue<>((i1, i2) -> i2 - i1);
        PriorityQueue<Integer> pqMinus = new PriorityQueue<>((i1, i2) -> i1 - i2);

        int answer = 0;
        int zero = 0;
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x > 0){
                pqPlus.offer(x);
            }else if(x < 0){
                pqMinus.offer(x);
            }else{
                zero++;
            }
        }

        while(pqPlus.size() > 1){
            int num1 = pqPlus.poll();
            int num2 = pqPlus.poll();

            if(num1 * num2 > num1 + num2){
                answer += num1 * num2;
            }else{
                answer += num1 + num2;
            }
        }

        if(pqPlus.size() == 1){
            answer += pqPlus.poll();
        }

        while(pqMinus.size() > 1){
            answer += pqMinus.poll() * pqMinus.poll();
        }

        if(!pqMinus.isEmpty() && zero == 0){
            answer += pqMinus.poll();
        }

        System.out.println(answer);
    }
}