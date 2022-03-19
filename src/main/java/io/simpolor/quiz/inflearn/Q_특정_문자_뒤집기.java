package io.simpolor.quiz.inflearn;

import java.util.Scanner;

public class Q_특정_문자_뒤집기 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String strings = in.nextLine();

        String answer = solution(strings);
        System.out.println(answer);
    }

    public static String solution(String strings){

        char[] chars = strings.toCharArray();
        int lt = 0;
        int rt = chars.length - 1;

        while (lt < rt) {
            if(!Character.isAlphabetic(chars[lt])){
                lt++;
            }else if(!Character.isAlphabetic(chars[rt])){
                rt--;
            }else{
                char temp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = temp;
                lt++;
                rt--;
            }
        }

        return String.valueOf(chars);
    }


}
