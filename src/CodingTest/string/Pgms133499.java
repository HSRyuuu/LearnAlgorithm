package CodingTest.string;
/**
 * package : CodingTest.string
 * class name : Pgms133499.java
 * date : 2023-06-15 오후 6:33
 * note : 옹알이(2) / lv1 / 문자열다루기
 */
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String str : babbling){
            char[] chars = str.toCharArray();
            String lastWord = "hello";
            boolean possible = true;
            int idx = 0;
            while(idx<str.length() && possible){
                if(chars[idx] == 'a' && idx<=str.length()-3){
                    if(str.substring(idx,idx+3).equals("aya") && !lastWord.equals("aya")){
                        lastWord = "aya";
                        idx+=3;
                    }else{
                        possible = false;
                        break;
                    }
                }else if(chars[idx] == 'y' && idx<=str.length()-2){
                    if(str.substring(idx,idx+2).equals("ye") && !lastWord.equals("ye")){
                        lastWord = "ye";
                        idx+=2;
                    }else{
                        possible = false;
                        break;
                    }
                }else if(chars[idx] == 'w' && idx<=str.length()-3){
                    if(str.substring(idx,idx+3).equals("woo") && !lastWord.equals("woo")){
                        lastWord = "woo";
                        idx+=3;
                    }else{
                        possible = false;
                        break;
                    }
                }else if(chars[idx] == 'm' && idx<=str.length()-2){
                    if(str.substring(idx,idx+2).equals("ma") && !lastWord.equals("ma")){
                        lastWord = "ma";
                        idx+=2;
                    }else{
                        possible = false;
                        break;
                    }
                }else{
                    possible = false;
                    break;
                }

            }
            if(possible){
                answer++;
            }
        }
        return answer;
    }

    public int solution2(String[] babbling) {
        int answer = 0;
        for(String str : babbling){
            if(str.contains("ayaaya") || str.contains("yeye") || str.contains("woowoo") || str.contains("mama")) {
                continue;
            }
            str = str.replaceAll("aya"," ");
            str = str.replaceAll("ye"," ");
            str = str.replaceAll("woo"," ");
            str = str.replaceAll("ma"," ");

            if(str.trim().length()==0){
                answer++;
            }
        }
        return answer;
    }

}

public class Pgms133499 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("=== case 1 ===");

        String[] babbling = {"aya", "yee", "u", "maa"}; //1
        System.out.println("my solution : " + sol.solution(babbling));
        System.out.println("solution2 : " + sol.solution2(babbling));

        System.out.println("=== case 2 ===");
        String[] babbling2 = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}; //2
        System.out.println("my solution : " + sol.solution(babbling2));
        System.out.println("solution2 : " + sol.solution2(babbling2));

    }


}
