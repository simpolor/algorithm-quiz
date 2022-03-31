package io.simpolor.quiz.inflearn.집합;

import java.util.Scanner;

// 복합적 문제
public class Q28_연속_부분수열 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        int answer = solution(n, m, arr);
        System.out.print(answer);
    }

    // n제곱 2중 for문도 사용가능하지만 시합복잡도가 올라감
    // 하지만 m만큰 for문을 반복하면 되지 않을까? 그것보단, while문에 lt, rt를 이용
    public static int solution(int n, int m, int[] arr){

        int answer=0, sum=0, lt=0;

        // 우측으로 구하다가 합계가 목표값 보단 크게되면 좌측 값을 줄이기 시작
        for(int rt=0; rt<n; rt++){ // 증가하고,
            sum += arr[rt]; // 더하고
            if(sum == m){ // 비교하고
                answer++;
            }
            while (sum >= m){
                sum -= arr[lt++]; // 빼고 증가
                if(sum == m){
                    answer++;
                }
            }
        }

        return answer;
    }
}
