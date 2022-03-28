package io.simpolor.quiz.inflearn.문자열;

import java.util.Scanner;

public class Q3_문장_속_단어 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine(); // nextLine 한줄만 입력 가능

        System.out.println(solution(str));
    }

    public static String solution(String str){

        String answer = "";
        int min = Integer.MIN_VALUE;
        int pos;

        while ((pos = str.indexOf(' ')) != -1){
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if(len > min){
                min = len;
                answer = tmp;
            }

            str = str.substring(pos + 1);
        }

        if(str.length() > min){
            answer = str;
        }

        return answer;



    }

    public static String solution1(String str) {

        String answer = "";
        int min = Integer.MIN_VALUE;
        String[] strings = str.split(" ");
        for(String s : strings){
            if(s.length() > min){
                answer = s;
                min = s.length();
            }
        }

        return answer;
    }

    public static String solution2(String str) {

        int index = 0;
        String[] strings = str.split(" ");

        for(int i=0; i<strings.length; i++){
            if(strings[i].length() > strings[index].length()){
                index = i;
            }
        }

        return strings[index];
    }




}
