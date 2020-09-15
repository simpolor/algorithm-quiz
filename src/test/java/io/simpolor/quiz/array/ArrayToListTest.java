package io.simpolor.quiz.array;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayToListTest {

    @Test
    public void testToListByArrayAsList(){

        String[] array = new String[]{"나봉수", "라봉팔", "김형희", "하지민"};
        System.out.println("before : "+Arrays.toString(array));

        List<String> list = Arrays.asList(array);
        System.out.println("after : "+list);
    }

    @Test
    public void testToListByArrayList(){

        String[] array = new String[]{"나봉수", "라봉팔", "김형희", "하지민"};
        System.out.println("before : "+Arrays.toString(array));

        List<String> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("after : "+list);
    }

    @Test
    public void testToListByArrayStream(){

        String[] array = new String[]{"나봉수", "라봉팔", "김형희", "하지민"};
        System.out.println("before : "+Arrays.toString(array));

        List<String> list = new ArrayList<>(Arrays.stream(array).collect(Collectors.toList()));
        System.out.println("after : "+list);
    }

}
