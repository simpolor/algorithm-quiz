package io.simpolor.quiz.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class test {

    @Test
    public void test(){

        String[] participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] completion = new String[]{"stanko", "ana", "mislav"};

        String result = solution(participant, completion);
        System.out.println("result : "+result);
    }

    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> result = new HashMap<>();
        for(String p : participant){
            result.put(p, Objects.nonNull(result.get(p)) ? result.get(p)+1 : 1);
        }

        for(String c : completion){
            result.put(c, Objects.nonNull(result.get(c)) ? result.get(c)-1 : 0);
        }

        for(String key : result.keySet()){
            if(result.get(key) == 1){
                return key;
            }
        }

        return "";
    }
}
