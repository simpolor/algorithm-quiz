package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1024 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 단어를 하나 입력받는다.
     *
     * 입력받은 단어(영어)의 각 문자를
     *
     * 한줄에 한 문자씩 분리해 출력한다.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 단어(영어) 하나를 입력받는다.
     * (단, 단어의 길이는 20글자 이하이다.)
     *
     * Boy
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 단어(영어)를 문자 단위로 나누어
     * 한 줄에 한개씩 ‘ ’로 묶어서 출력한다.
     *
     * 'B'
     * 'o'
     * 'y'
     *
     * ----------------------------
     * 도움말
     * ----------------------------
     * char d[30];       //최대 30문자를 저장할 수 있는 저장 공간 준비. 마지막에 널문자가 옴을 고려해야함.
     * scanf("%s", d); //그 공간에 키보드로 입력된 내용을 저장. 단, 공백이 있으면 거기까지만 입력됨.
     * for(i=0; d[i]!='\0'; i++) //저장된 내용을 하나하나씩 검사해서 널문자가 아닌 동안 아래 내용 실행
     * {
     *    printf("\'%c\'\n", d[i]);
     * }
     *
     */
    public static void main(String[] args) {

        // 입력 예
        Scanner in = new Scanner(System.in);
        String input = in.next();
        in.close();

        // 출력 예
        /* char[] array = input.toCharArray();
        for(char c : array){
            System.out.format("'%s'%n", c);
        } */

        char[] output = new char[input.length()];
        for(int i=0; i<input.length(); i++){
            output[i] = input.charAt(i);
        }

        for(char c : output){
            System.out.format("'%s'%n", c);
        }

        for(int i=0; i<input.length(); i++){
            output[i] = input.charAt(i);
        }
    }
}
