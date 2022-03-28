package io.simpolor.quiz.inflearn.배열;

import java.util.Scanner;

public class Q19_점수계산 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = in.nextInt();
        }

        int answer = solution(n, nums);
        System.out.print(answer);
    }

    public static int solution(int n, int[] nums){

        int sum = 0;
        int cnt = 0;
        for(int i=0; i<n; i++){
            cnt++;
            if(nums[i] == 1){
                sum += cnt;
            }else{
                cnt = 0;
            }
        }

        return sum;
    }
}
