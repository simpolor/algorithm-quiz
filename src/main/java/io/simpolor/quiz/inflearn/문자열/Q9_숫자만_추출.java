package io.simpolor.quiz.inflearn.문자열;

import java.util.Scanner;

public class Q9_숫자만_추출 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.next();

        int answer = solution(str);
        System.out.println(answer);
    }

    public static int solution(String str){

        String answer = "";
        for(char c : str.toCharArray()){
            if(Character.isDigit(c)){
                answer += c;
            }
        }

        return Integer.parseInt(answer);
    }

    public static int solution1(String str){

        // 아스키 번호 48(0) ~ 57(9)
        int answer = 0;
        for(char c : str.toCharArray()){
            if(c >= 48 && c <= 57){
                answer = answer * 10 + (c-48);
            }
        }

        return answer;
    }

}
