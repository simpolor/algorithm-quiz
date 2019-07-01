package io.simpolor.quiz.doit.chapter01;

import java.util.Scanner;

public class Min4 {

    public static void main(String[] args){

        // System.in은 키보드와 연결된 표준 입력 스트림
        Scanner stdIn = new Scanner(System.in);

        System.out.println("세 정수의 최댓값을 구합니다.");
        System.out.print("a의 값 : "); int a = stdIn.nextInt(); // 키보드로 입력한 값 중 "정숫값"을 얻어냅니다.ㄴ
        System.out.print("b의 값 : "); int b = stdIn.nextInt();
        System.out.print("c의 값 : "); int c = stdIn.nextInt();
        System.out.print("d의 값 : "); int d = stdIn.nextInt();


        System.out.println("최소값은 "+min3(a, b, c, d)+" 입니다.");
    }

    // 연습문제
    static int min3(int a, int b, int c, int d){
        int min = a;
        if(b < min) min = b;
        if(c < min) min = c;
        if(d < min) min = d;

        return min;
    }


}
