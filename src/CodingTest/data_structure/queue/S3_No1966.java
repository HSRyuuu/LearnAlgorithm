package CodingTest.data_structure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * package : CodingTest.data_structure.queue
 * class name : No1966.java
 * date : 2024-03-14 오전 12:39
 * info : 프린터 큐 / Silver 3 / Queue
 * link :
 */
public class S3_No1966 {

    static class Document{
        int idx;
        int importance;

        public Document(int idx, int importance) {
            this.idx = idx;
            this.importance = importance;
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //문서의 개수
            int M = Integer.parseInt(st.nextToken()); //궁금한 문서가 몇번째에 놓여있는지

            st = new StringTokenizer(br.readLine());

            Queue<Document> queue = new LinkedList<>();

            for(int j = 0; j < N; j++){
                queue.offer(new Document(j, Integer.parseInt(st.nextToken())));
            }

            int ans = solution(queue, M);

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

    static int solution(Queue<Document> queue, int target){
        int count = 0;

        while(true){
            Document cur = queue.poll();


            boolean best = true; //cur이 best Option인지 여부
            for (Document document : queue) {
                if(document.importance > cur.importance){
                    best = false;
                    break;
                }
            }

            if(best){
                count++;
                if(cur.idx == target){
                    break;
                }
            }else{
                queue.offer(cur);
            }
        }

        return count;
    }
}