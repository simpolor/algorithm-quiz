package io.simpolor.quiz.inflearn.배열;

import java.util.Scanner;

public class Q13_큰_수_출력하기 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = in.nextInt();
        }

        int answer = solution(n, nums);
        System.out.println(answer);
    }

    public static int solution(int n, int[] nums){

        int answer = 1;

        int max = nums[0];
        for(int i=1; i<n; i++){
            if(nums[i] > max){
                answer++;
                max = nums[i];
            }
        }

        return answer;
    }

}
