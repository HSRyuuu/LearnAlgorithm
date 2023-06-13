package CodingTest.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 11478번 : 서로다른 부분 문자열
 * silver 3
 */
public class No11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        String str = br.readLine();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=1;i<=str.length();i++){
            for (int j = 0; j < str.length()-i+1; j++) {
                map.put(str.substring(j,j+i),1);
            }
        }
        System.out.println(map.size());

    }
}
