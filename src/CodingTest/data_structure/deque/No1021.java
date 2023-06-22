package CodingTest.data_structure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * package : baekjoon.data_structure.deque
 * class name : No1021.java
 * date : 2023-06-13 오후 2:31
 * note : 회전하는 큐 / silver3 / deque
 */
public class No1021 {
    static int result = 0;
    public static void main(String[] args) throws IOException {
        List<Integer> list = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //큐의 크기
        int M = Integer.parseInt(st.nextToken()); //뽑아내려고하는 수의 개수
        for(int i=1;i<=N;i++){
            list.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            if(list.get(0) == target){
                list.remove(0);
                continue;
            }
            if(list.size() == 1){
                break;
            }

            if(findFirst(list,target) < findLast(list,target)){
                while(list.get(0) != target){
                    no2MoveLeft(list);
                }
            }else{
                while(list.get(0) != target){
                    no3MoveRight(list);
                }
            }
            list.remove(0);
        }
        System.out.println(result);

    }
    static void no2MoveLeft(List<Integer> list){
        list.add(list.remove(0));
        result++;
    }
    static void no3MoveRight(List<Integer> list){
        list.add(0,list.remove(list.size()-1));
        result++;
    }
    static int findFirst(List<Integer> list,int x){
        int result = 0;
        for(int i=1;i<list.size();i++){
            result++;
            if(list.get(i) == x)break;
        }
        return result;
    }
    static int findLast(List<Integer> list, int x){
        int result = 0;
        for(int i=list.size()-1;i>=0;i--){
            result++;
            if(list.get(i) == x)break;
        }
        return result;
    }

}
