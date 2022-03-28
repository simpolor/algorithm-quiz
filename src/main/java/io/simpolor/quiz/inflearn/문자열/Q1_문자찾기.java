package io.simpolor.quiz.inflearn.문자열;

import java.util.Scanner;

public class Q1_문자찾기 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.next();
        char c = in.next().charAt(0);

        System.out.println(solution(str, c));
    }

    public static int solution(String str, char c){

        str = str.toUpperCase();
        c = Character.toUpperCase(c);

        int answer = 0;
        for(char x : str.toCharArray()){
            if(x == c){
                answer++;
            }
        }

        return answer;
    }

    public static int solution1(String str, char c){

        str = str.toUpperCase();
        c = Character.toUpperCase(c);

        int answer = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == c){
                answer++;
            }
        }

        return answer;
    }


}
