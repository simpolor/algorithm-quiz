package io.simpolor.quiz.inflearn.탐색;

import java.util.Scanner;

public class Q56_파보나치_재귀_메모이제이션 {

    static int[] fibo;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        fibo = new int[n+1];
        solution(n);
        for(int i=1; i<=n; i++){
            System.out.println(fibo[i] + " ");
        }
        // int answer = solution(n);
        // System.out.println(answer);
    }

    // 첫번째과 두번째 항은 파보나치수열이므로 1 1 2 3 5 으로 시작하므로 1이 리턴
    // 느린 이유는 하나를 호출할때마다 1부터 다시 계산되므로 느려진다. 그걸 방지하기 위하여 전역변수 하나 사용
    // 메모제이션을 사용하면 1초만에 재귀를 처리할 수 있음, 좌측값이 우선 계산하므로 우측에서는 값을 가져오기만 하면됨
    public static int solution(int n){

        // 메모제이션 활용
        if(fibo[n] > 0){
            return fibo[n];
        }

        if(n == 1 || n == 2){
            return fibo[n] = 1;
        }else{
            // return fibo[n] = solution(n-2) + solution(n-1);
            return fibo[n] = solution(n-2) + solution(n-1);
        }
        /*if(n == 1){
            return 1;
        }else if(n == 2){
            return 1;
        }else{
            return solution(n-2) + solution(n-1);
        }*/

    }
}
