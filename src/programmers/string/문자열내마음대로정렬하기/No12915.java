package programmers.string.문자열내마음대로정렬하기;
import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings);
        Arrays.sort(strings, (o1, o2) -> {
            char c1 = o1.charAt(n);
            char c2 = o2.charAt(n);
            if(c1>c2){
                return 1;
            } else if (c1 < c2) {
                return -1;
            }
            return 0;
        });
        return strings;
    }
}
public class No12915 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] strings1 = {"sun", "bed", "car"};
        int n1 =1;
        String[] ans1 = sol.solution(strings1, n1);
        System.out.println(Arrays.toString(ans1));

        String[] strings2 = {"abce", "abcd", "cdx"};
        int n2 = 2;
        String[] ans2 = sol.solution(strings2, n2);
        System.out.println(Arrays.toString(ans2));



    }
}
