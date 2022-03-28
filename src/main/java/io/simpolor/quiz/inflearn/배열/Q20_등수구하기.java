package io.simpolor.quiz.inflearn.배열;

import java.util.Scanner;

// 무언가를 전체를 비교할때는 2중 for문을 사용
public class Q20_등수구하기 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = in.nextInt();
        }

        int[] answer = solution(n, nums);
        for(int num : answer){
            System.out.print(num + " ");
        }

    }

    public static int[] solution(int n, int[] nums){

        int[] answer = new int[n];

        for(int i=0; i<n; i++){
            int cnt = 1;
            for(int j=0; j<n; j++){
                if(nums[i] < nums[j]){
                    cnt++;
                }
            }
            answer[i] = cnt;
        }

        return answer;
    }
}
