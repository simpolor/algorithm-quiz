package io.simpolor.quiz.map;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapInitTest {

    @Test
    public void testMapInit(){

        Map<String, Integer> map = new HashMap<String, Integer>(){
            {
                put("A", 1);
                put("B", 2);
            }
        };

        System.out.println(map);
    }

    @Test
    public void testCollectionsSingletonMap(){

        Map<String, Integer> map = Collections.singletonMap("A", 1);

        System.out.println(map);
    }

    @Test
    public void testStream(){

        Map<String, Integer> map = Stream.of(new Object[][] {
                { "A", 1 },
                { "B", 2 },
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

        System.out.println(map);
    }

    @Test
    public void testStreamEntry(){

        Map<String, Integer> map = Stream.of(
                new AbstractMap.SimpleEntry<>("A", 1),
                new AbstractMap.SimpleEntry<>("B", 2))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(map);
    }

    @Test
    public void testStreamImmutableEntry(){

        Map<String, Integer> map = Stream.of(
                new AbstractMap.SimpleImmutableEntry<>("A", 1),
                new AbstractMap.SimpleImmutableEntry<>("B", 2))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(map);
    }

    @Test
    public void testStreamMapInit(){

        Map<String, Integer> map = Stream.of(new Object[][] {
                { "A", 1 },
                { "B", 2 },
        }).collect(Collectors.collectingAndThen(
                Collectors.toMap(data -> (String)data[0], data -> (Integer)data[1]),
                Collections::<String, Integer> unmodifiableMap));

        System.out.println(map);
    }


}
