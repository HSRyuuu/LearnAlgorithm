package CodingTest.graph.DFS;

/**
 * package : CodingTest.graph.DFS
 * class name : P43163.java
 * date : 2023-07-18 오후 9:27
 * info : 단어 변환 / lv 3 / dfs
 * link : https://school.programmers.co.kr/learn/courses/30/lessons/43163?language=java
 */
class Solution {

    static boolean[] visited;
    static int ans = 0;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);
        return ans;
    }
    static void dfs(String begin, String target, String[] words, int cnt){
        if(begin.equals(target)){
            ans = cnt;
            return;
        }

        for(int i = 0; i < words.length; i++){
            if(visited[i]){
                continue;
            }
            int k = 0;

            for(int j = 0; j < begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)){
                    k++;
                }
            }

            if(k == begin.length()-1){ //한글자 빼고 나머지가 같은 단어
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
public class P43163 {
}
