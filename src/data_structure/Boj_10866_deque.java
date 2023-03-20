package data_structure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10866_deque {
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();
    public static int rear = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for(int i=0;i<n;i++){
            String str = br.readLine();
            int x = 0;

            if(str.startsWith("push")){
                st = new StringTokenizer(str);
                str = st.nextToken();
                x = Integer.parseInt(st.nextToken());
            }

            switch(str){
                case "push_front" : push_front(x);break;
                case "push_back" : push_back(x);break;
                case "pop_front" : pop_front();break;
                case "pop_back" : pop_back();break;
                case "size" : size();break;
                case "empty": empty();break;
                case "front": front();break;
                case "back" : back();break;
            }
        }
        System.out.println(sb);
    }

    public static void push_front(int x){
        rear++;
        for(int i=rear;i>0;i--){
            arr[i] = arr[i-1];
        }
        arr[0]=x;
    }

    public static void push_back(int x){
        arr[rear] = x;
        rear++;
    }

    public static void pop_front(){
        if(rear==0){
            sb.append(-1).append("\n");
        }else{
            sb.append(arr[0]).append("\n");
            for(int i=0;i<rear;i++){
                arr[i] = arr[i+1];
            }
            rear--;
        }

    }

    public static void pop_back(){
        if(rear==0){
            sb.append(-1).append("\n");
        }else {
            sb.append(arr[rear - 1]).append("\n");
            arr[rear-1] = 0;
            rear--;
        }
    }

    public static void size(){
        sb.append(rear).append("\n");
    }

    public static void empty(){
        if(rear==0)sb.append(1).append("\n");
        else sb.append(0).append("\n");
    }

    public static void front(){
        if(rear==0)sb.append(-1).append("\n");
        else sb.append(arr[0]).append("\n");
    }

    public static void back(){
        if(rear==0)sb.append(-1).append("\n");
        else sb.append(arr[rear-1]).append("\n");
    }
}
