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

    @Test
    public void testValueCollection(){

        Map<String, Integer> map = new HashMap();
        map.put("김철수", 17);
        map.put("안영미", 19);
        map.put("나영희", 16);

        Collection<Integer> values = map.values();

        for(int value : values){
            System.out.printf("value : %d%n", value);
        }
    }

    @Test
    public void testValueIterator(){

        Map<String, Integer> map = new HashMap();
        map.put("김철수", 17);
        map.put("안영미", 19);
        map.put("나영희", 16);

        Iterator<Integer> iterator = map.values().iterator();

        while (iterator.hasNext()){
            int value = iterator.next();
            System.out.printf("value : %d%n", value);
        }
    }

    @Test
    public void testForEach(){

        Map<String, Integer> map = new HashMap();
        map.put("김철수", 17);
        map.put("안영미", 19);
        map.put("나영희", 16);

        map.forEach((key, value) -> System.out.printf("key : %s, value : %d%n", key, value));
    }

    @Test
    public void testForEachByEntrySet(){

        Map<String, Integer> map = new HashMap();
        map.put("김철수", 17);
        map.put("안영미", 19);
        map.put("나영희", 16);

        map.entrySet().forEach((entry)
                -> System.out.printf("key : %s, value : %d%n", entry.getKey(), entry.getValue()));
    }

    @Test
    public void testForEachByKeySetAndValue(){

        Map<String, Integer> map = new HashMap();
        map.put("김철수", 17);
        map.put("안영미", 19);
        map.put("나영희", 16);

        map.keySet().forEach((key) -> System.out.printf("key : %s%n", key));
        map.values().forEach((value) -> System.out.printf("value : %d%n", value));
    }
}
