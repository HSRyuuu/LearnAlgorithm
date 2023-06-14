package CodingTest.data_structure.stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No5327S{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int T = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            List<Character> list = new LinkedList<>();
            int idx = 0;
            for (char c : str.toCharArray()) {
                if(list.isEmpty() && (c == '<' || c =='>' || c == '-')){
                    continue;
                }else if(!(c == '<' || c =='>' || c == '-')){
                    list.add(idx,c);
                    idx++;
                }else if(c == '<'){
                    if(idx == 0 || list.isEmpty()){
                        idx = 0;
                        continue;
                    }
                    idx--;
                }else if(c == '>'){
                    if(idx == list.size())continue;
                    idx++;
                }else if(c == '-'){
                    if(idx == 0 || list.isEmpty()){
                        idx = 0;
                        continue;
                    }
                    list.remove(--idx);
                }
            }
            for (Character ch : list) {
                ans.append(ch);
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }

}