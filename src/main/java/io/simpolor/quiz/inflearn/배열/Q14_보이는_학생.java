package io.simpolor.quiz.inflearn.배열;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q14_보이는_학생 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = in.nextInt();
        }

        List<Integer> answer = solution(n, nums);
        for(int num : answer){
            System.out.print(num + " ");
        }
    }

    public static List<Integer> solution(int n, int[] nums){

        List<Integer> answer = new ArrayList<>();
        answer.add(nums[0]);
        for(int i=1; i<n; i++){
            if(nums[i] > nums[i-1]){
                answer.add(nums[i]);
            }
        }

        return answer;
    }

}
