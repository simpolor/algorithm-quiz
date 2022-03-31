package io.simpolor.quiz.inflearn.집합;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 교집합
public class Q26_공통원소_구하기 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr1 = new int[n];
        for(int i=0; i<n; i++){
            arr1[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] arr2 = new int[m];
        for(int i=0; i<m; i++){
            arr2[i] = in.nextInt();
        }

        ArrayList<Integer> answer = solution(n, m, arr1, arr2);
        for(int x : answer){
            System.out.print(x + " ");
        }
    }

    // 두개를 비교할 경우는 정렬을 미리 시켜야한다.
    public static ArrayList<Integer> solution(int n, int m, int[] arr1, int[] arr2){

        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int p1=0, p2=0;
        while (p1<n && p2<m){
            if(arr1[p1] == arr2[p2]){
                answer.add(arr1[p1]);
                p1++;
                p2++;
            }else if(arr1[p1] < arr2[p2]){
                p1++;
            }else{
                p2++;
            }
        }

        return answer;
    }
}
