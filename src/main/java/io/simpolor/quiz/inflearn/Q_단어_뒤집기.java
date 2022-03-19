package io.simpolor.quiz.inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Q_단어_뒤집기 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int size = in.nextInt();

        String[] strings = new String[size];
        for(int i=0; i<size; i++){
            strings[i] = in.next();
        }

        String[] answer = solution(size, strings);
        for(String s : answer){
            System.out.println(s);
        }
    }

    public static String[] solution(int size, String[] strings){

        String[] answer = new String[size];
        for(int i=0; i<size; i++){
            char[] chars = strings[i].toCharArray();
            int lt = 0;
            int rt = chars.length - 1;

            while (lt < rt) {
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;
                lt++;
                rt--;
            }

            answer[i] = String.valueOf(chars);
        }

        return answer;
    }

    public static String[] solution1(int size, String[] strings){

        String[] answer = new String[size];
        for(int i=0; i<size; i++){
            answer[i] = new StringBuilder(strings[i]).reverse().toString();
        }

        return answer;
    }

    public static String[] solution2(int size, String[] strings){

        String[] answer = new String[size];
        for(int i=0; i<size; i++){
            char[] chars = strings[i].toCharArray();

            int div = chars.length / 2;
            for(int j=0; j<div; j++){
                char temp = chars[j];
                chars[j] = chars[(chars.length - 1) - j];
                chars[(chars.length - 1) - j] = temp;
            }
            answer[i] = Arrays.toString(chars);
        }

        return answer;
    }


}
