package io.simpolor.quiz.inflearn.배열;

import java.util.Scanner;

// 앞수와 그 앞수를 더 합친 값을 반복하는 수열
// ex) 1, 1, 2, 3, 5, 8, 13...
public class Q16_파보나치_수열 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] answer = solution(n);
        for(int num : answer){
            System.out.print(num + " ");
        }
    }

    public static int[] solution(int n){

        int[] answer = new int[n];
        int a=1, b=1, c;
        answer[0] = a;
        answer[1] = b;
        for(int i=2; i<n; i++){
            c = a + b;
            answer[i] = c;
            a = b;
            b = c;
        }

        return answer;
    }

    public static int[] solution1(int n){

        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for(int i=2; i<n; i++){
            answer[i] = answer[i-2] + answer[i-1];
        }

        return answer;
    }
}
