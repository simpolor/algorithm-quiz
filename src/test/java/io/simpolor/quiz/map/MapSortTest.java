package io.simpolor.quiz.map;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class MapSortTest {

    // // https://codechacha.com/ko/java-sort-map/

    @Test
    public void testLinkedHashMapSort(){

        Map<String, String> map = new LinkedHashMap<>();
        map.put("A", "5");
        map.put("Z", "2");
        map.put("C", "11");
        map.put("G", "4");
        map.put("E", "9");


        List<Map.Entry<String, String>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, String> entry : result.entrySet()) {
            System.out.printf("Key : %s, value : %s%n", entry.getKey(), entry.getValue());
        }
    }

    @Test
    public void testTreeMapSort(){

        Comparator<String> comparator = (s1, s2)->s2.compareTo(s1);

        Map<String, String> map = new TreeMap<>(comparator);
        map.put("A", "5");
        map.put("Z", "2");
        map.put("C", "11");
        map.put("G", "4");
        map.put("E", "9");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf("Key : %s, value : %s%n", entry.getKey(), entry.getValue());
        }
    }

    @Test
    public void testHashMapToArraySort(){

        Map<String, String> map = new HashMap<>();
        map.put("A", "5");
        map.put("Z", "2");
        map.put("C", "11");
        map.put("G", "4");
        map.put("E", "9");


        List<String> keyList = new ArrayList<>(map.keySet());
        keyList.sort((s1, s2) -> s1.compareTo(s2));

        for (String key : keyList) {
            System.out.printf("Key : %s, value : %s%n", key, map.get(key));
        }
    }

    @Test
    public void testHashMapToStreamSort(){

        Map<String, String> map = new HashMap<>();
        map.put("A", "5");
        map.put("Z", "2");
        map.put("C", "11");
        map.put("G", "4");
        map.put("E", "9");


        List<Map.Entry<String, String>> entries =
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        // .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toList());


        for (Map.Entry<String, String> entry: entries) {
            System.out.printf("Key : %s, value : %s%n", entry.getKey(), entry.getValue());
        }
    }

    @Test
    public void testHashMapByStreamSorted(){

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 5);
        map.put("Z", 2);
        map.put("C", 11);
        map.put("G", 4);
        map.put("E", 9);

        map.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> {
                System.out.printf("Key : %s, value : %d%n", entry.getKey(), entry.getValue());
            });

        map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .forEach(entry -> System.out.printf("Key : %s, value : %d%n", entry.getKey(), entry.getValue()));

        map.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .forEach(entry -> System.out.printf("Key : %s, value : %d%n", entry.getKey(), entry.getValue()));
    }
}
