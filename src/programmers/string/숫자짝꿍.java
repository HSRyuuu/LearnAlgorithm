package programmers.string;

/**
 * 프로그래머스 - 숫자짝꿍
 * LV1
 * 문자열 두개가 주어지고,
 * 두개의 문자열에 동시에 존재하는 숫자를 뽑아내어 해당 숫자로 만들 수 있는 가장 큰 수를 return
 */
public class 숫자짝꿍 {
    public static void main(String[] args) {
        System.out.println(solution("100","2345"));
        System.out.println(solution("100","123450"));
        System.out.println(solution("5525","1255"));


    }
    public static String solution(String X, String Y) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int[] Xarr = new int[10];
        int[] Yarr = new int[10];
        for(int i=0;i<X.length();i++){
            int x = Character.getNumericValue(X.charAt(i));
            Xarr[x]++;
        }
        for(int i=0;i<Y.length();i++){
            int y = Character.getNumericValue(Y.charAt(i));
            Yarr[y]++;
        }
        for(int i=9;i>=0;i--){
            if(Xarr[i]!=0 && Yarr[i]!=0){
                int num = Math.min(Xarr[i],Yarr[i]);
                for(int j=0;j<num;j++){
                    sb.append(i);
                }
            }
        }
        answer = sb.toString();

        if(answer.startsWith("0")){
            return "0";
        }else if(answer.equals("")){
            return "-1";
        }
        return answer;
    }
}
