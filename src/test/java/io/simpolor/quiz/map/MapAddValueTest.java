package io.simpolor.quiz.map;

import org.junit.Test;

import java.util.*;

public class MapAddValueTest {

    @Test
    public void testComputeIfAbsent(){

        String[][] strings = new String[][]{{"key1", "A"}, {"key2", "B"}, {"key1", "C"}};

        Map<String, List<String>> map = new HashMap<>();
        for(String[] s : strings){
            map.computeIfAbsent(
                    s[0],
                    v -> new ArrayList<>()
            ).add(s[1]);
        }

        System.out.println(map);
    }
}
