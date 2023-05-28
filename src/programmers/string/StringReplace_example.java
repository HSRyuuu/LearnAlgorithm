package programmers.string;

//replace 직접 구현
public class StringReplace_example {
    public static void main(String[] args) {
        String str = "Hello Java, Nice to meet you! Java is fun!";
        String find = "Java";
        String to = "자바";
        System.out.println("변경 전 : " + str);
        System.out.println("변경 후 : "+solution(str, find, to));

        str = "Hello Man! Hello Guys!!";
        find = "Hello";
        to = "~Hi~";
        System.out.println("변경 전 : " + str);
        System.out.println("변경 후 : "+solution(str, find, to));

    }
    public static String solution(String str, String find, String to){
        String answer="";
        int find_len = find.length();
        int to_len = to.length();
        String originalStr = str;

        for(int i = 0;i<str.length();){
            if(isCorrect(i,str,find)){
                answer+=to;
                i+=find_len;
            }else{
                answer += str.charAt(i);
                i++;
            }
        }

        return answer;
    }
    static boolean isCorrect(int idx, String str, String find){
        boolean isCorrect = true;
        if(idx > str.length()-find.length())return false;

        for(int i=0;i<find.length();i++){
            if(str.charAt(idx+i) != find.charAt(i)){
                isCorrect = false;
                break;
            }
        }
        return isCorrect;
    }

}
