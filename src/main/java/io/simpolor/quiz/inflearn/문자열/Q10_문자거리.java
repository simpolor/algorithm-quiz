package io.simpolor.quiz.inflearn.문자열;

import java.util.Scanner;

public class Q10_문자거리 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.next();
        char t = in.next().charAt(0);

        int[] answer = solution(str, t);
        for(int i : answer){
            System.out.print(i+" ");
        }
    }

    // 양쪽 거리
    public static int[] solution(String str, char t){

        int[] answer = new int[str.length()];

        int lt = 1000;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == t){
                lt = 0;
            }else{
                lt += 1;
            }
            answer[i] = lt;
        }

        int rt = 1000;
        for(int i=str.length()-1; i>=0; i--){
            if(str.charAt(i) == t){
                rt = 0;
            }else{
                rt += 1;
            }

            if(answer[i] > rt){
                answer[i] = rt;
            }
        }

        return answer;
    }

    // 왼쪽 거리
    public static int[] solution1(String str, char t){

        int[] answer = new int[str.length()];

        int lt = 1000;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == t){
                lt = 0;
            }else{
                lt += 1;
            }
            answer[i] = lt;
        }

        return answer;
    }

}
