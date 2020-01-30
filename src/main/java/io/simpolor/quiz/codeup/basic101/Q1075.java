package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1075 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 정수(1 ~ 100) 1개가 입력되었을 때 카운트다운을 출력해보자.
     *
     *
     * 예시
     * int n;
     * scanf("%d", &n);
     * while(n!=0)
     * {
     *   n=n-1; //n--; 와 같다.
     *   printf("%d", n);
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
     * 11씩 줄이면서 한 줄에 하나씩 0이 될 때까지 출력한다.
     *
     * 5
     * 4
     * 3
     * 2
     * 1
     * 0
     *
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();;
        while (input != 0){
            input--;
            System.out.println(input);
        }
        scanner.close();
    }
}
