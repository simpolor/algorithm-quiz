package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1057 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 두 개의 참(1) 또는 거짓(0)이 입력될 때,
     * 참/거짓이 서로 같을 때에만 참이 계산되는 프로그램을 작성해보자.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 1 또는 0의 값만 가지는 2개의 정수가 공백을 두고 입력된다.
     *
     * 0 0
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 참/거짓이 서로 같을 때에만 1을 출력하고, 그 외의 경우에는 0을 출력한다.
     *
     * 1
     *
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input1 = scanner.nextInt();
        int input2 = scanner.nextInt();
        scanner.close();

        boolean val1 = (input1 != 0);
        boolean val2 = (input2 != 0);

        if(val1 == val2){
            System.out.printf("%d", 1);
        }else{
            System.out.printf("%d", 0);
        }
    }
}
