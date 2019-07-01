package io.simpolor.quiz.doit.chapter01;

import java.util.Scanner;

public class Digits {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int num;

        System.out.println("2자리의 정수를 입력하세요.");
        do{
            System.out.print("입력 : ");
            num = scanner.nextInt();
        }while(num < 10 || num > 99 );

        System.out.println("변수 no의 값은 "+num+"입니다.");
    }

}
