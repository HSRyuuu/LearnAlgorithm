package programmers.unclassfied;


import java.util.*;

/**
 * 개인정보 수집 유효기한
 * 2023 KAKAO BLIND RECRUITMENT
 */
public class Programmers_0514_2 {
    public static void main(String[] args) {
        //입력 값
        Solution sol = new Solution();
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(Arrays.toString(sol.solution(today, terms, privacies)));
    }
    static class Solution{
        public int[] solution(String today, String[] terms, String[] privacies) {
            List<Integer> ansList = new ArrayList<>();
            Map<String, Integer> termMap = new HashMap<>();

            //today를 숫자로 표현
            int todayNum = getDate(today);

            for(String s : terms){
                String[] term = s.split(" ");
                termMap.put(term[0], Integer.parseInt(term[1]));
            }

            for(int i=0;i<privacies.length;i++){
                StringTokenizer st = new StringTokenizer(privacies[i]);
                String privacyDay = st.nextToken();
                int term = termMap.get(st.nextToken());

                //유효기한을 숫자로 표현
                int pNum = getDate(privacyDay)+term*28-1;

                if(todayNum>pNum)ansList.add(i+1);
            }
            return ansList.stream().mapToInt(Integer ->Integer).toArray();
        }

        private int getDate(String today){
            int year = Integer.parseInt(today.substring(0,4));
            int month = Integer.parseInt(today.substring(5,7));
            int day = Integer.parseInt(today.substring(8,10));
            return year*12*28 + month*28 + day;
        }
    }


}
