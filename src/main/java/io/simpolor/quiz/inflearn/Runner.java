package io.simpolor.quiz.inflearn;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String answer = solution(str);
        System.out.println(answer);
    }

    public static String solution(String str){

        String answer = "";
        for(String s : str.split(" ")){
            if(s.length() > answer.length()){
                answer = s;
            }
        }

        return answer;
    }
}
