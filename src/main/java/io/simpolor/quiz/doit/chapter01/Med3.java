package io.simpolor.quiz.doit.chapter01;

import java.util.Scanner;

public class Med3 {

    public static void main(String[] args){

        // System.in은 키보드와 연결된 표준 입력 스트림
        Scanner stdIn = new Scanner(System.in);

        System.out.println("세 정수의 중앙값을 구합니다.");
        System.out.print("a의 값 : "); int a = stdIn.nextInt(); // 키보드로 입력한 값 중 "정숫값"을 얻어냅니다.ㄴ
        System.out.print("b의 값 : "); int b = stdIn.nextInt();
        System.out.print("c의 값 : "); int c = stdIn.nextInt();


        System.out.println("중앙값은 "+med3(a, b, c)+" 입니다.");
    }

    // 연습문제
    static int med3(int a, int b, int c){
        if(a >= b){
            if(b >= c){
                return b;
            }else if(a <= c){
                return a;
            }else{
                return c;
            }
        }else if(a > c){
            return a;
        }else if(b > c){
            return c;
        }else{
            return b;
        }
    }


}
