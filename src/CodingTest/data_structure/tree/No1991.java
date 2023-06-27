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
    Node root;

    public BinarySearchTree(char data) {
        this.root = new Node(data, null, null);
    }

    public void insertNode(Node node, char parent, char left, char right){
        if(node.data == parent){
            if(left == '.'){
                node.left = null;
            }else{
                node.left = new Node(left, null, null);
            }
            if(right == '.'){
                node.right = null;
            }else{
                node.right = new Node(right, null, null);
            }
        }else{
            if(node.left != null){
                insertNode(node.left, parent, left, right);
            }
            if(node.right != null){
                insertNode(node.right, parent, left, right);
            }
        }
    }
    public void preOrder(Node node){
        if(node == null)return;
        System.out.print(node.data);

        preOrder(node.left);
        preOrder(node.right);
    }
    public void inOrder(Node node){
        if(node == null)return;

        inOrder(node.left);
        System.out.print(node.data);
        inOrder(node.right);
    }
    public void postOrder(Node node){
        if(node == null)return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }
}
public class No1991{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        BinarySearchTree bst = new BinarySearchTree('A');

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            bst.insertNode(bst.root, parent, left, right);
        }
        bst.preOrder(bst.root);
        System.out.println();
        bst.inOrder(bst.root);
        System.out.println();
        bst.postOrder(bst.root);
    }
}