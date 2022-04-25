package io.simpolor.quiz.inflearn.정렬;

import java.util.Arrays;
import java.util.Scanner;

// 결정 알고리즘(이분 검색을 방법, 오름차순 정렬이 기본 조건)
public class Q51_뮤직비디오 {

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

    // 이분검색 방법으로 m으로 분배했을때 mid 값을 만족하면, 다시 이분검색
    // 이분 검색에 안걸릴 경우 lt가 rt보다 커진다
    public static int solution(int n, int m, int[] arr){

        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while (lt <= rt){
            int mid = (lt+rt) / 2;
            if(count(arr, mid) <= m){
                answer = mid;
                rt = mid - 1;
            }else{
                lt = mid + 1;
            }
        }

        return answer;
    }

    public static int count(int[] arr, int capacity){

        int cnt = 1; // dvd 장소
        int sum = 0; // 곡의 합
        for(int num : arr){
            if((sum+num) > capacity){
                sum = num;
                cnt++;
            }else{
                sum += num;
            }
        }

        return cnt;
    }
}
