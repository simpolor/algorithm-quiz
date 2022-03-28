package io.simpolor.quiz.inflearn.배열;

import java.util.Scanner;

public class Q15_가위바위보 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = in.nextInt();
        }
        int[] b = new int[n];
        for(int i=0; i<n; i++){
            b[i] = in.nextInt();
        }

        String answer = solution(n, a, b);
        for(char c : answer.toCharArray()){
            System.out.println(c);
        }
    }

    public static String solution(int n, int[] a, int[] b){

        String answer = "";
        for(int i=0; i<n; i++){
            if(a[i] == b[i]){
                answer += "D";
            }else if(a[i]==1 && b[i]==3){
                answer += "A";
            }else if(a[i]==2 && b[i]==1){
                answer += "A";
            }else if(a[i]==3 && b[i]==2){
                answer += "A";
            }else{
                answer += "B";
            }
        }

        return answer;
    }

    public static String[] solution1(int n, int[] a, int[] b){

        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            if(a[i] == b[i]){
                answer[i] = "D";
            }else if(a[i]==1 && b[i]==3){
                answer[i] = "A";
            }else if(a[i]==2 && b[i]==1){
                answer[i] = "A";
            }else if(a[i]==3 && b[i]==2){
                answer[i] = "A";
            }else{
                answer[i] = "B";
            }
        }

        return answer;
    }
}
