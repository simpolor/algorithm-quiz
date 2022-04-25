package io.simpolor.quiz.inflearn.정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q48_장난꾸러기 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        List<Integer> answer = solution(n, arr);
        for(int x : answer){
            System.out.print(x + " ");
        }

    }

    // 문제에서 키순으로 정렬을 한다고 미리 공시
    // 핵심은 깊은 복사 후 정렬하여 두개의 배열을 같은자리 비교처리
    public static List<Integer> solution(int n, int[] arr){

        List<Integer> answer = new ArrayList<>();

        int[] temp = arr.clone();
        Arrays.sort(temp);

        for(int i=0; i<n; i++){
            if(arr[i] != temp[i]){
                answer.add(i+1);
            }
        }

        return answer;
    }
}
