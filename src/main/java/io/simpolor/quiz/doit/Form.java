package io.simpolor.quiz.doit;

import java.util.Scanner;

public class Form {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("정수를 입려하세요.");
        int num = scanner.nextInt();


        do{
            System.out.print("n의 값 : ");
            num = scanner.nextInt();
        }while(num <= 0);

        System.out.println("입력한 수는 : "+num);



    }

}
