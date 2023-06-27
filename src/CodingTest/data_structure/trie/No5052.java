package CodingTest.data_structure.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * package : CodingTest.data_structure.trie
 * class name : No5052.java
 * date : 2023-06-27 오후 10:07
 * note : 전화번호 목록 / gold 4 / 트라이
 */
public class No5052{
    static class Node{
        HashMap<Character, Node> child;
        boolean endOfWord;

        public Node() {
            this.child = new HashMap<>();
            this.endOfWord = false;
        }
    }
    static class Trie{
        Node root;

        public Trie(Node root) {
            this.root = new Node();
        }
        public void insert(String str){
            Node node = this.root;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                node.child.putIfAbsent(ch, new Node());

                node = node.child.get(ch);
            }
            node.endOfWord = true;
        }
        public boolean search(String str){
            Node node = this.root;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(node.endOfWord){
                    return true;
                }
                if(node.child.containsKey(ch)){
                    node = node.child.get(ch);
                }else{
                    return false;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());


            Trie trie = new Trie(new Node());
            String[] list = new String[N];
            for (int i = 0; i < N; i++) {
                String number = br.readLine();
                list[i] = number;
                trie.insert(number);
            }

            boolean passFlag = true;
            for(int i = 0 ; i < N; i++){
                if(trie.search(list[i])){
                    passFlag = false;
                }
            }
            if(passFlag){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}
