package io.simpolor.quiz.inflearn.탐색;

import java.util.Scanner;

// 팩토리얼은 1부터 N까지 곱 ( 1*2*3*4*5 )
public class Q55_팩토리얼 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int answer = solution(n);
        System.out.println(answer);
    }

    // return하는 순간 계산처리가 됨
    public static int solution(int n){

        if(n == 1){
            return 1;
        }else{
            return n * solution(n-1);
        }

    }
}
