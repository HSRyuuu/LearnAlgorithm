package CodingTest.data_structure.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
    char data;
    Node left;
    Node right;


    public Node(char data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
class BinarySearchTree{
    Node head;
    public BinarySearchTree(char head) {
        this.head = new Node(head,null, null);
    }


    public void insertNode(Node cur,char root, char left, char right){
        if(cur.data == root){
            if(left == '.'){
                cur.left = null;
            }else{
                cur.left =  new Node(left,null, null);
            }
            if(right == '.'){
                cur.right = null;
            }else{
                cur.right = new Node(right, null, null);
            }

        }else{
            if(cur.left != null){
                insertNode(cur.left, root, left, right);
            }
            if(cur.right != null){
                insertNode(cur.right, root, left, right);
            }
        }
    }
    public void preOrder(Node node){
        if(node == null) return;
        System.out.print(node.data);

        preOrder(node.left);
        preOrder(node.right);

    }
    public void inOrder(Node node){
        if(node == null) return;

        inOrder(node.left);
        System.out.print(node.data);
        inOrder(node.right);

    }
    public void postOrder(Node node){
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }

}
/**
 * package : CodingTest.data_structure.tree
 * class name : No1991.java
 * date : 2023-06-16 오후 10:57
 * note : 트리 순회 / preOrder, inOrder, postOrder / silver1
 */
public class No1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());

        BinarySearchTree tree = new BinarySearchTree('A');
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.insertNode(tree.head, parent, left, right);
        }
        tree.preOrder(tree.head);
        System.out.println();
        tree.inOrder(tree.head);
        System.out.println();
        tree.postOrder(tree.head);
    }
}
