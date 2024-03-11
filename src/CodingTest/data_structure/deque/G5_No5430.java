package CodingTest.data_structure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class G5_No5430 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            char[] commands = br.readLine().toCharArray();
            int arrLength = Integer.parseInt(br.readLine()); //쓸모 없는 값
            String inputString = br.readLine();

            Deque<Integer> deque = new LinkedList<>();
            if (inputString.length() > 2) {
                for (String s : inputString.substring(1, inputString.length() - 1).split(",")) {
                    deque.offer(Integer.parseInt(s));
                }
            }
            //deque에 값 넣기 끝

            boolean error = false;
            boolean reversed = false;

            for(char command : commands){
                //R일 때
                if(command == 'R'){
                    if(reversed){
                        reversed = false;
                    }else{
                        reversed = true;
                    }
                    continue;
                }
                //D인데 deque가 비었을 때
                if(deque.isEmpty()){
                    error = true;
                    break;
                }
                //D 일때 정상 로직
                if(reversed){
                    deque.pollLast();
                }else{
                    deque.pollFirst();
                }
            }

            if(error){
                sb.append("error\n");
            }else{
                appendDeque(deque, reversed);
            }
        }
        System.out.println(sb);
    }

    static void appendDeque(Deque<Integer> deque, boolean reversed) {
        if (deque.size() == 0) {
            sb.append("[]\n");
            return;
        }

        sb.append("[");
        if(reversed){
            while(!deque.isEmpty()){
                sb.append(deque.pollLast()).append(",");
            }
        }else{
            while(!deque.isEmpty()){
                sb.append(deque.pollFirst()).append(",");
            }
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append("]").append("\n");
    }
}