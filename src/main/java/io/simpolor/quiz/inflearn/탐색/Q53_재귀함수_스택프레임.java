package io.simpolor.quiz.inflearn.탐색;

import java.util.Scanner;

// 재귀함수란 자기가 자기 자신을 호출하는 함수
public class Q53_재귀함수_스택프레임 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        solution(n);
    }

    // 재귀함수는 스택프레임(스택이라는 자료구조)을 사용한다
    // 함수가 스택에 쌓인다.
    // 스택프레임에 쌓이는 정보(매개변수, 지역변수, 복귀주소를 정보를 저장)
    // 자기 자신을 호출하는 수간 스택프레임은 저장, 호출한 아래부터는 대기 상태
    public static void solution(int n){

        if(n == 0){
            return;
        }else{
            solution(n-1);
            System.out.println(n + " ");
        }

    }
}
