package io.simpolor.quiz.inflearn.정렬;

import java.util.Arrays;
import java.util.Scanner;

// 이분 검색이란, 정렬 해놓고 중간부터 특정 숫자를 찾는 방법을 말한다.
public class Q50_이분검색 {

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

    // 이분 검색 알고리즘!
    // 시간복잡고 검색 문제
    public static int solution(int n, int m, int[] arr){

        int answer = 0;
        Arrays.sort(arr);

        int lt=0, rt=n-1;
        while (lt <= rt){
            int mid = (lt + rt) / 2;
            if(arr[mid] == m){
               answer = mid+1;
               break;
            }

            if(arr[mid] > m){
                rt = mid - 1;
            }else{
                lt = mid + 1;
            }
        }

        return answer;
    }
}
