package io.simpolor.quiz.inflearn.정렬;

import java.util.Arrays;
import java.util.Scanner;

public class Q47_중복확인 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        String answer = solution(n, arr);
        System.out.print(answer);

    }

    // 해쉬맵으로 풀수 있지만, 정렬을 통해 이웃한 숫자로 확인하는 방법
    public static String solution(int n, int[] arr){

        Arrays.sort(arr);
        for(int i=0; i<n-1; i++){
            if(arr[i] == arr[i+1]){
                return "D";
            }
        }

        return "U";
    }
}
