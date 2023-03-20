package two_pointer.no12891_sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_12891_sliding_window {
        static int A,C,G,T;
        static int countArr[] = new int[4]; // A, C, G, T : 부분 문자열의 각 알파벳 개수 저장
         static String fullStr;
        static int front, end;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            // s : 전체 문자열 길이 , p : 부분 문자열 길이
            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            //전체 문자열 저장
            fullStr = br.readLine();

            //각 문자 A,C,G,T의 필요 개수를 저장
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());

            //front인덱스, end 인덱스의 초기값 지정  /  count : 가능한 개수
            front = 0;
            end = p-1;
            int count = 0;

            //첫번째 부분 문자열에 대해 , countArr 설정
            //마지막 인덱스는 while문 내에서 시작할때 판단하므로 제외
            for(int i=front;i<=end;i++){
                if(fullStr.charAt(i)=='A')countArr[0]++;
                else if(fullStr.charAt(i)=='C')countArr[1]++;
                else if(fullStr.charAt(i)=='G')countArr[2]++;
                else if(fullStr.charAt(i)=='T')countArr[3]++;
            }
            if(checkAvailable())count++;

            //while문의 마지막에 end++해서 fullStr.length()와 같아지면 종료
            while(end!=fullStr.length()-1){
                addEndIndex();
                removeFrontIndex();
                front++;
                end++;

                if(checkAvailable())count++;
            }
            System.out.println(count);
        }

    private static void removeFrontIndex() {
        if(fullStr.charAt(front)=='A')countArr[0]--;
        else if(fullStr.charAt(front)=='C')countArr[1]--;
        else if(fullStr.charAt(front)=='G')countArr[2]--;
        else if(fullStr.charAt(front)=='T')countArr[3]--;
    }

    private static void addEndIndex() {
        if(fullStr.charAt(end+1)=='A')countArr[0]++;
        else if(fullStr.charAt(end+1)=='C')countArr[1]++;
        else if(fullStr.charAt(end+1)=='G')countArr[2]++;
        else if(fullStr.charAt(end+1)=='T')countArr[3]++;
    }

    //countArr이 비밀번호로 이용 가능한지 판단하는 checkAvailable 메소드
    public static boolean checkAvailable(){
            if(countArr[0]>=A && countArr[1]>=C && countArr[2]>=G && countArr[3]>=T)return true;
            else return false;
        }

    }
