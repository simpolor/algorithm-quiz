package io.simpolor.quiz.map;

import org.junit.Test;

import java.util.*;

public class MapPrintTest {

    @Test
    public void testKeySet(){

        Map<String, Object> map = new HashMap();
        map.put("김철수", 17);
        map.put("안영미", 19);
        map.put("나영희", 16);

        for(String key : map.keySet()){
            System.out.printf("key : %s, value : %d%n", key, map.get(key));
        }
    }

    @Test
    public void testKeySetIterator(){

        Map<String, Object> map = new HashMap();
        map.put("김철수", 17);
        map.put("안영미", 19);
        map.put("나영희", 16);

        Iterator<String> iterator = map.keySet().iterator();

        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.printf("key : %s, value : %d%n", key, map.get(key));
        }
    }

    @Test
    public void testEntrySet(){

        Map<String, Object> map = new HashMap();
        map.put("김철수", 17);
        map.put("안영미", 19);
        map.put("나영희", 16);

        for(Map.Entry<String, Object> entry : map.entrySet()){
            System.out.printf("key : %s, value : %d%n", entry.getKey(), entry.getValue());
        }
    }

    @Test
    public void testEntrySetIterator(){

        Map<String, Object> map = new HashMap();
        map.put("김철수", 17);
        map.put("안영미", 19);
        map.put("나영희", 16);

        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, Object> entry = iterator.next();
            System.out.printf("key : %s, value : %d%n", entry.getKey(), entry.getValue());
        }
    }
}
