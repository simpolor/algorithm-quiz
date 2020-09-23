package io.simpolor.quiz.list;

import org.junit.Test;

import java.util.*;

public class ListSortTest {

    @Test
    public void testListSort(){

        List<String> list = Arrays.asList("나봉수", "라봉팔", "김형희", "하지민");
        System.out.println("before : "+list);

        list.sort(Comparator.naturalOrder());
        System.out.println("after : "+list);
    }

    @Test
    public void testListReverseSort(){

        List<String> list = Arrays.asList("나봉수", "라봉팔", "김형희", "하지민");
        System.out.println("before : "+list);

        list.sort(Comparator.reverseOrder());
        System.out.println("after : "+list);
    }
}
