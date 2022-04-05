package io.simpolor.quiz.inflearn.해쉬;

import java.util.HashMap;
import java.util.Scanner;

public class Q34_모든_아나그램_찾기 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();

        int answer = solution(s, t);
        System.out.print(answer);
    }

    // map을 equal로 비교하는게 중요, 그리고 remove로 삭제가 필요
    public static int solution(String s, String t){

        int answer = 0;

        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();
        for(char c : t.toCharArray()){
            bm.put(c, bm.getOrDefault(c, 0) + 1);
        }

        int L = t.length() - 1;
        for(int i=0; i<L; i++){
            am.put(s.charAt(i), am.getOrDefault(s.charAt(i), 0) + 1);
        }

        int lt = 0;
        for(int rt=L; rt<s.length(); rt++){
            am.put(s.charAt(rt), am.getOrDefault(s.charAt(rt), 0) + 1);
            if(am.equals(bm)){
                answer++;
            }
            am.put(s.charAt(lt), am.get(s.charAt(lt)) - 1);
            if(am.get(s.charAt(lt)) == 0){
                am.remove(s.charAt(lt));
            }
            lt++;
        }



        return answer;
    }
}
