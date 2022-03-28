package io.simpolor.quiz.inflearn.문자열;

import java.util.Scanner;

// 뒤로 앞으로도 같은 문자 gooG
public class Q7_회문문자열 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.next();

        String answer = solution(str);
        System.out.println(answer);
    }

    public static String solution(String str){

        String temp = new StringBuilder(str).reverse().toString();
        if(!str.equalsIgnoreCase(temp)){
            return "NO";
        }

        return "YES";
    }

    public static String solution1(String str){

        str = str.toUpperCase();

        int rt = str.length() - 1;
        for(int i=0; i<str.length()/2; i++){
            if(str.charAt(i) != str.charAt(rt - i)){
                return "NO";
            }
        }

        return "YES";
    }

}
