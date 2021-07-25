package io.simpolor.quiz;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestExecute {

    @Test
    public void test(){

        String s = "statistics";
        int solution = solution(s);

        System.out.println(solution);
    }

    public int solution(String s) {

        Map<Character, Integer> map = new HashMap<>();

        char[] chars = s.toCharArray();
        for(char c : chars){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(int i=0; i < chars.length; i++){
            if(map.get(chars[i]) == 1){
                return i+1;
            }
        }

        return -1;
    }

}
