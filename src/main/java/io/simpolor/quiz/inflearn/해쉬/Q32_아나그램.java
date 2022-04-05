package io.simpolor.quiz.inflearn.해쉬;

import java.util.HashMap;
import java.util.Scanner;

// 아나그램이란, 길이가 두 단어가 순서만 다르고 알파뱃 갯수가 같은 것을 말합니다.
public class Q32_아나그램 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();

        String answer = solution(s1, s2);
        System.out.print(answer);
    }

    // 비교하는 문제는 첫번째 문자열은 증가, 비교 문자열은 감소 시키는 방식, 모두 0이면 일치
    public static String solution(String s1, String s2){

        String answer = "YES";

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(char c : s1.toCharArray()){
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for(char c : s2.toCharArray()){
            if(!hashMap.containsKey(c) || hashMap.get(c) == 0){
                return "NO";
            }
            hashMap.put(c, hashMap.get(c) - 1);
        }

        for(char key : hashMap.keySet()){
            if(hashMap.get(key) != 0){
                return "NO";
            }
        }

        return answer;
    }
}
