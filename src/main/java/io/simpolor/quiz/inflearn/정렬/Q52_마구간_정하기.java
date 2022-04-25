package io.simpolor.quiz.inflearn.정렬;

import java.util.Arrays;
import java.util.Scanner;

// 결정 알고리즘(이분 검색을 방법, 오름차순 정렬이 기본 조건)
public class Q52_마구간_정하기 {

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

    // 최대값, 최소값, 정렬 필요, rt는 최대값, lt는 1
    // 두말의 최대 거리값을 구하는 문제 ( arr[i] - ep >= mid 카운트 갯수로써 유효함 )
    // 카운트는 1부터 시작, mid = lt+rt/2
    public static int solution(int n, int m, int[] arr){

        int answer = 0;

        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[n-1];

        while (lt <= rt){
            int mid = (lt+rt) / 2;
            if(count(arr, mid) >= m){
                answer = mid;
                lt = mid + 1;
            }else{
                rt = mid - 1;
            }
        }

        return answer;
    }

    public static int count(int[] arr, int distinct){

        int cnt = 1; // 말의 갯수
        int endpoint = arr[0];
        for(int i=0; i<arr.length; i++){
            if((arr[i] - endpoint) >= distinct){
                cnt++;
                endpoint = arr[i];
            }
        }

        return cnt;
    }
}
