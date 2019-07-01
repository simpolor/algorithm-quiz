package io.simpolor.quiz.doit.chapter01;

import java.util.Scanner;

public class TriangleLB {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int num = 0;
        System.out.println("왼쪽 아래가 직각인 이등변 삼각형을 출력합니다.");

        do{
            System.out.print("몇 단 삼격형 입니까? : ");
            num = scanner.nextInt();
        }while(num <= 0);

        for(int i=1; i<=num; i++){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
