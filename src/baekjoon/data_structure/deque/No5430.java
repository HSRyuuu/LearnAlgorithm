package baekjoon.data_structure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 백준 5430번 : AC
 * gold 5
 * 데크, 자료구조, 구현, 문자열, 파싱
 */
public class No5430 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());

        for (int k = 0; k < N; k++) {
            //케이스 시작
            boolean isError = false;
            //입력부
            String cmd = br.readLine();//커맨드
            int n = Integer.parseInt(br.readLine());//배열의 길이
            String arrStr = br.readLine();//배열 문자열
            char[] chars = cmd.toCharArray();

            //배열 만들기
            Deque<Integer> deque = new LinkedList<>();
            if(arrStr.length() > 2){
                String[] split = arrStr.substring(1,arrStr.length()-1).split(",");
                for (int i=0;i< split.length;i++){
                    deque.addLast(Integer.parseInt(split[i]));
                }
            }

            //커맨드 실행
            boolean isReverse = false;
            for(int i=0;i<chars.length;i++){
                char ch = chars[i];
                if(ch == 'R'){
                    if(isReverse){
                        isReverse = false;
                    }else{
                        isReverse = true;
                    }
                }else if(ch == 'D'){
                    if(deque.isEmpty()){
                        isError = true;
                        break;
                    }else if(isReverse){
                        deque.pollLast();
                    }else{
                        deque.pollFirst();
                    }
                }else{
                    isError = true;
                    break;
                }
            }
            if (isError){
                sb.append("error\n");
            }else{
                print(deque,isReverse);
            }
            //케이스 끝
        }
        System.out.println(sb);
    }

    static void print(Deque<Integer> deque, boolean isReverse){

        if(deque.size() == 0){
            sb.append("[]\n");
            return;
        }
        sb.append("[");
        int size = deque.size();
        if(isReverse){
            for(int i=0;i<size-1;i++){
                sb.append(deque.pollLast()).append(",");
            }
        }else{
            for(int i=0;i<size-1;i++){
                sb.append(deque.pollFirst()).append(",");
            }
        }
        sb.append(deque.poll()+"]\n");
    }

}