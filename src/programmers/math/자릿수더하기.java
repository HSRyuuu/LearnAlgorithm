package programmers.math;

/** 자릿수 더하기
 *
 * 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
 * 예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
 *
 * 제한사항
 * N의 범위 : 100,000,000 이하의 자연수
 */
public class 자릿수더하기 {
    public static void main(String[] args) {
        //입력 값
        int N1 = 123; //6
        int N2 = 987; //24
        System.out.println(solution(N1));
        System.out.println(solution2(N2));
    }

    public static int solution(int n){
        int answer = 0;
        String str = Integer.toString(n);
        for(int i=0;i<str.length();i++){
            answer+=Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        return answer;
    }
    public static int solution2(int n){
        int answer = 0;
        while(n>0){
            answer+=n%10;
            if(n<10)break;
            n/=10;
        }
        return answer;
    }

}
