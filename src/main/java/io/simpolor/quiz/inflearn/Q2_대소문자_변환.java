package io.simpolor.quiz.inflearn;

import java.util.Scanner;

public class Q2_대소문자_변환 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.next();

        System.out.println(solution(str));
    }

    public static String solution(String str){

        String answer = "";
        for(char x : str.toCharArray()){ // 32 차이
            if(x >= 65 && x <= 90){
                answer+= (char)(x+32);
            }else if(x >= 97 && x <=122){
                answer+= (char)(x-32);
            }
        }

        return answer;
    }

    public static String solution1(String str){

        String answer = "";
        for(char x : str.toCharArray()){
            if(Character.isLowerCase(x)){
                answer+= Character.toUpperCase(x);
            }else if(Character.isUpperCase(x)){
                answer+= Character.toLowerCase(x);
            }
        }

        return answer;
    }


}
