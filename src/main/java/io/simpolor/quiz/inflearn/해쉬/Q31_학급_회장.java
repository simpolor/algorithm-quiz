package io.simpolor.quiz.inflearn.해쉬;

import java.util.HashMap;
import java.util.Scanner;

public class Q31_학급_회장 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String k = in.next();

        char answer = solution(n, k);
        System.out.print(answer);
    }

    public static char solution(int n, String k){

        char answer = ' ';

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i=0; i<n; i++){
            hashMap.put(k.charAt(i), hashMap.getOrDefault(k.charAt(i), 0)+1);
        }

        int max = Integer.MIN_VALUE;
        for(char key : hashMap.keySet()){
            if(hashMap.get(key) > max){
                max = hashMap.get(key);
                answer = key;
            }
        }

        return answer;
    }
}
