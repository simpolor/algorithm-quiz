package io.simpolor.quiz.inflearn.배열;

import java.util.Scanner;

// 1과 자기 자신 외의 약수를 가지지 않는 1보다 큰 자연수
// ex) 에스토스테네스 체 푸는 방법이 가장 빠르다.
// 해당 수의 배수를 해당 값까지 체크한다.
public class Q17_소수 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int answer = solution(n);
        System.out.print(answer);
    }

    public static int solution(int n){

        int answer = 0;

        int[] nums = new int[n+1];
        for(int i=2; i<n+1; i++){
            if(nums[i] == 0){
                answer++;
                for(int j=i; j<n+1; j=j+i){
                    nums[j] = 1;
                }
            }
        }

        return answer;
    }
}
