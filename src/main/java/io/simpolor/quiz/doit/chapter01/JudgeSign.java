package io.simpolor.quiz.doit.chapter01;

import java.util.Scanner;

public class JudgeSign {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("정수를 입려하세요.");
        int num = scanner.nextInt();


        if(0 < num){
            System.out.println("이 수는 양수 입니다.");
        }else if(0 > num){
            System.out.println("이 수는 음수 입니다.");
        }else{
            System.out.println("이 수는 0 입니다.");
        }


    }

}
