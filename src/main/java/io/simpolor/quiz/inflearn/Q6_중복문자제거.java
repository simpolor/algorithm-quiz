package io.simpolor.quiz.inflearn;

import java.util.Scanner;

public class Q6_중복문자제거 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.next();

        String answer = solution(str);
        System.out.println(answer);
    }

    public static String solution(String str){

        String answer = "";
        for(int i=0; i<str.length(); i++){
            if(str.indexOf(str.charAt(i)) == i){
                answer += str.charAt(i);
            }
        }

        return answer;
    }

}
