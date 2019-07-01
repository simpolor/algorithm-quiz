package io.simpolor.quiz.doit.chapter01;

import java.util.Scanner;

public class SumWhile {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 구합니다.");
        System.out.print("n의 값 : ");
        int num = scanner.nextInt();

        int sum = 0;
        int i = 1;

        while(i <= num){
            sum += i;
            i++;
        }

        System.out.println("1부터 "+num+"까지의 합은 "+sum+"입니다.");

    }

}
