package io.simpolor.quiz.codeup.basic101;

import java.io.IOException;
import java.util.Scanner;

public class Q1088 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 1부터 입력한 정수까지 1씩 증가시켜 출력하는 프로그램을 작성하되,
     * 3의 배수인 경우는 출력하지 않도록 만들어보자.
     *
     * 예를 들면,
     * 1 2 4 5 7 8 10 11 13 14 ...
     * 와 같이 출력하는 것이다.
     *
     *
     * 참고
     * 반복문 안에서 continue;가 실행되면 그 아래의 내용을 건너뛰고, 다음 반복을 수행한다.
     * 즉, 다음 반복으로 넘어가는 것이다.
     *
     * 예시
     * for(i=1; i<=n; i++) //1부터 시작해 n까지 1씩 증가시키면서 반복한다.
     * {
     *   if(i%2==0)
     *     continue; //짝수라면? 아래 부분은 건너뛰고! 계속~
     *   printf("%d ", i); //결국 짝수가 아닐 때에만 출력된다.
     * }
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 정수 1개를 입력받는다.
     * (1 ~ 100)
     *
     * 10
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 1부터 입력한 정수보다 작거나 같을 때까지 1씩 증가시켜 출력하되
     * 3의 배수는 출력하지 않는다.
     *
     * 1 2 4 5 7 8 10
     *
     */
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        scanner.close();

        for(int i=1; i<=input; i++){
           if(!(i % 3 == 0)){
               System.out.println(i);
           }
        }
    }
}
