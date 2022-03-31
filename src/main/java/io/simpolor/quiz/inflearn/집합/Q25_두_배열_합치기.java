package io.simpolor.quiz.inflearn.집합;

import java.util.ArrayList;
import java.util.Scanner;

// 미리 두 배열은 정렬해서 들어온다.
// 두 값을 비교하여 작은 수를 추가하고 포인터를 옴긴다.
public class Q25_두_배열_합치기 {

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

    // 반복문을 한번만 도는게 핵심
    // arrayList를 사용한다는 사실, 괜히 배열로 고생하지 않기
    public static ArrayList<Integer> solution(int n, int m, int[] arr1, int[] arr2){

        ArrayList<Integer> answer = new ArrayList<>();

        int p1=0, p2=0;
        while (p1<n && p2<m){
            if(arr1[p1] < arr2[p2]){
                answer.add(arr1[p1++]);
            }else{
                answer.add(arr2[p2++]);
            }
        }

        while (p1<n){
            answer.add(arr1[p1++]);
        }
        while (p2<m){
            answer.add(arr2[p2++]);
        }

        return answer;
    }
}
