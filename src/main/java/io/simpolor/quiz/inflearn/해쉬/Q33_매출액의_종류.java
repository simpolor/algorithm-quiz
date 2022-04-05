package io.simpolor.quiz.inflearn.해쉬;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Q33_매출액의_종류 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        ArrayList<Integer> answer = solution(n, k, arr);
        for(int num : answer){
            System.out.print(num + " ");
        }

    }

    // 2 point와 size()와 remove 함수가 핵심
    public static ArrayList<Integer> solution(int n, int k, int[] arr){

        ArrayList<Integer> answer = new ArrayList();

        int lt=0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0; i<k-1; i++){ // -1을 해놓아야 rt를 움직이면서 갈 수 있음, 0, 1, 2까지 세팅
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        for(int rt=k-1; rt<n; rt++){ // -1을 해야 밀면서 갈 수 있음
            hashMap.put(arr[rt], hashMap.getOrDefault(arr[rt], 0) + 1);
            answer.add(hashMap.size());

            hashMap.put(arr[lt], hashMap.get(arr[lt]) - 1);
            if(hashMap.get(arr[lt]) == 0){ // 2포인트 기법
                hashMap.remove(arr[lt]);
            }
            lt++;
        }

        return answer;
    }
}
