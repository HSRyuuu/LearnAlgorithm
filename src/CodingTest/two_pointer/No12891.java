package CodingTest.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * package : CodingTest.two_pointer
 * class name : No12891.java
 * date : 2023-06-23 오후 6:41
 * note : DNA 비밀번호 / silver 2 / 투포인터 (슬라이딩 윈도우)
 */
public class No12891{
    static int[] dnaArr;
    static String dnaStr;
    static int[] arr = new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken()); //전체 문자열의 길이
        int P = Integer.parseInt(st.nextToken()); //부분 문자열의 길이

        dnaStr = br.readLine();

        dnaArr = new int[4]; // A, C, G, T
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            dnaArr[i] = Integer.parseInt(st.nextToken());
        }
        //맨 처음 문자열
        for (int i = 0; i < P; i++) {
            char ch  = dnaStr.charAt(i);
            if(ch == 'A'){
                arr[0]++;
            }else if(ch == 'C'){
                arr[1]++;
            }else if(ch == 'G'){
                arr[2]++;
            }else if(ch == 'T'){
                arr[3]++;
            }
        }

        int cnt = 0;
        int pointer = 0;
        while(true){
            if(arrayCheck(arr)){
                cnt++;
            }

            if(pointer + P == dnaStr.length())break;

            removeFirst(pointer);
            addLastPlus1(pointer + P);

            pointer++;
        }

        System.out.println(cnt);
    }
    private static void removeFirst(int pointer){
        char ch = dnaStr.charAt(pointer);
        if(ch == 'A'){
            arr[0]--;
        }else if(ch == 'C'){
            arr[1]--;
        }else if(ch == 'G'){
            arr[2]--;
        }else if(ch == 'T'){
            arr[3]--;
        }
    }
    private static void addLastPlus1(int pointer){
        char ch = dnaStr.charAt(pointer);
        if(ch == 'A'){
            arr[0]++;
        }else if(ch == 'C'){
            arr[1]++;
        }else if(ch == 'G'){
            arr[2]++;
        }else if(ch == 'T'){
            arr[3]++;
        }
    }

    static boolean arrayCheck(int[] arr){
        for (int i = 0; i < 4; i++) {
            if(dnaArr[i] > arr[i]){
                return false;
            }
        }
        return true;
    }
}
