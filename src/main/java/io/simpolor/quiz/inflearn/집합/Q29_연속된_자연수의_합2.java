package io.simpolor.quiz.inflearn.집합;

import java.util.Scanner;

// 수학적 방식 ( 몫과 나머지로 이용 )
public class Q29_연속된_자연수의_합2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int answer = solution(n);
        System.out.print(answer);
    }

    // 숫자를 미리 배분,
    // [1] 1, 2, 15-3, 12/2=6, 1+6, 2+6 = 7, 8
    // [2] 1, 2, 3 15-6 9/3=3, 1+3, 2+3, 3+3 = 4, 5, 6
    // [3] 1, 2, 3, 4 15-9 6/4=17.5, 정확하게 나머지가 없이 나눠 떨어져야함
    // [4] 1, 2, 3, 4, 5 15-15 0/15=0, 1+0, 2+0, 3+0, 4+0, 5+0  = 1, 2, 3, 4, 5
    // 이 공식의 핵심은 12/2=6, 9/3=3, 0/15 이 부분을 알고 있는지다.
    public static int solution(int n){

        int answer=0, cnt=1; // 횟수
        n--; // 첫번째 1을 뺀 숫자
        while(n > 0){
            cnt++;
            n = n - cnt; // cnt(1, 2, 3) 값을 증분하면서 값을 빼면 확인 가능
            if(n % cnt == 0){ // 수학적으로 미리 공식을 알고 있기에 이러한 공식으로 확신이 있음
                answer++;
            }
        }

        return answer;
    }
}
