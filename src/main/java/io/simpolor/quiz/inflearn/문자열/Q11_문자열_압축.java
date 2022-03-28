package io.simpolor.quiz.inflearn.문자열;

import java.util.Scanner;

public class Q11_문자열_압축 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.next();

        String answer = solution(str);
        System.out.println(answer);
    }

    public static String solution(String str){

        String answer = "";
        str += " ";

        int cnt = 1;
        for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                cnt++;
            }else{
                answer += str.charAt(i);
                if(cnt > 1){
                    answer += String.valueOf(cnt);
                    cnt = 1;
                }
            }
        }

        return answer;
    }

}
