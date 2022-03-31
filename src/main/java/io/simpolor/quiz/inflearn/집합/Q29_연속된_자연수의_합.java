package io.simpolor.quiz.inflearn.집합;

import java.util.Scanner;

// 2포인트 방식
public class Q29_연속된_자연수의_합 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int answer = solution(n);
        System.out.print(answer);
    }

    // 연속된 자연수의 합에 들어올 자연수는 n/2 + 1보다 큰 숫자 있을 수 없다.
    public static int solution(int n){

        int answer=0, sum=0, lt=0;

        int m = n/2+1;
        int[] arr = new int[m]; // 1부터 시작이니, 값 추가 필요
        for(int i=0; i<m; i++){
            arr[i] = i+1;
        }

        for(int rt=0; rt<m; rt++){
            sum += arr[rt];
            if(sum == n){
                answer++;
            }
            while(sum >= n){
                sum -= arr[lt++];
                if(sum == n){
                    answer++;
                }
            }
        }

        return answer;
    }
}
