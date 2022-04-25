package io.simpolor.quiz.inflearn.탐색;

import java.util.Scanner;

public class Q54_이진수_출력_재귀 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        solution(n);
    }

    public static void solution(int n){

        if(n == 0){
            return;
        }else{
            solution(n/2);
            System.out.println(n % 2 + " ");
        }

    }
}
