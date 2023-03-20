package two_pointer.no12891_sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_12891_sliding_window {
        static int A,C,G,T;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            // s : 전체 문자열 길이 , p : 부분 문자열 길이
            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            //전체 문자열 저장
            String fullStr = br.readLine();

            //각 문자 A,C,G,T의 필요 개수를 저장
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());

            //front인덱스, end 인덱스의 초기값 지정  /  count : 가능한 개수
            int front = 0;
            int end = p-1;
            int count = 0;

            //부분 문자열의 각 알파벳 개수 저장
            int countArr[] = new int[4]; // A, C, G, T

            //첫번째 부분 문자열에 대해 , countArr 설정
            //마지막 인덱스는 while문 내에서 시작할때 판단하므로 제외
            for(int i=front;i<end;i++){
                if(fullStr.charAt(i)=='A')countArr[0]++;
                else if(fullStr.charAt(i)=='C')countArr[1]++;
                else if(fullStr.charAt(i)=='G')countArr[2]++;
                else if(fullStr.charAt(i)=='T')countArr[3]++;
            }
            //while문의 마지막에 end++해서 fullStr.length()와 같아지면 종료
            while(end!=fullStr.length()){
                //이전 사이클에서 front의 값은 빼주고, end는 더하지 않고 인덱스만 ++ 해줬기 때문에
                //현재 end 인덱스의 값을 추가해 줌
                if(fullStr.charAt(end)=='A')countArr[0]++;
                else if(fullStr.charAt(end)=='C')countArr[1]++;
                else if(fullStr.charAt(end)=='G')countArr[2]++;
                else if(fullStr.charAt(end)=='T')countArr[3]++;
                //countArr이 비밀번호로 이용 가능한지 판단하는 checkAvailable 메소드
                boolean YN = checkAvailable(countArr);
                if(YN)count++;

                //현재 countArr의 첫번째 인덱스의 문자를 빼주고,
                //다음 사이클의 시작에서 바뀐 부분문자열의 마지막 인덱스를 추가해줌.
                if(fullStr.charAt(front)=='A')countArr[0]--;
                else if(fullStr.charAt(front)=='C')countArr[1]--;
                else if(fullStr.charAt(front)=='G')countArr[2]--;
                else if(fullStr.charAt(front)=='T')countArr[3]--;
                front++;

                end++;

            }
            System.out.println(count);
        }

        public static boolean checkAvailable(int[] countArr){
            if(countArr[0]>=A && countArr[1]>=C && countArr[2]>=G && countArr[3]>=T)return true;
            else return false;
        }

    }
