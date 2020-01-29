package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1074 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 정수(1 ~ 100) 1개가 입력되었을 때 카운트다운을 출력해보자.
     *
     *
     * while(조건)
     * {
     *   ...
     * }
     * 구조를 사용하자.
     *
     * 예시
     * int n;
     * scanf("%d", &n);
     * while(n!=0)
     * {
     *   printf("%d", n);
     *   n=n-1; //n--;와 같다.
     * }
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 정수 1개가 입력된다.
     * (1 ~ 100)
     *
     * 5
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 1씩 줄이면서 한 줄에 하나씩 1이 될 때까지 출력한다.
     *
     * 5
     * 4
     * 3
     * 2
     * 1
     *
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();;
        while (input != 0){
            System.out.println(input);
            input--;
        }
        scanner.close();
    }
}
