package io.simpolor.quiz.inflearn.문자열;

import java.util.Scanner;

// 뒤로 앞으로도 같은 문자 gooG, 정규식 이용
public class Q8_팰린드롬 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine(); // line은 한줄, next는 뛰어쓰기하면 끝.

        String answer = solution(str);
        System.out.println(answer);
    }

    public static String solution(String str){

        str = str.toUpperCase().replaceAll("[^A-z]", "");
        String temp = new StringBuilder(str).reverse().toString();

        if(!str.equals(temp)){
            return "NO";
        }

        return "YES";
    }

}
