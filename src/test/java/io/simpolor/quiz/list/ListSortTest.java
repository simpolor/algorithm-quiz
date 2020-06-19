package io.simpolor.quiz.list;

import org.junit.Test;

import java.util.*;

public class ListSortTest {

    @Test
    public void testListASCSort(){


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(6);
        list.add(2);
        list.add(5);

        System.out.println("before : " + list);
        list.sort(Comparator.naturalOrder());
        System.out.println("after : " + list);
    }

    @Test
    public void testListDESCSort(){


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(6);
        list.add(2);
        list.add(5);

        System.out.println("before : " + list);
        list.sort(Comparator.reverseOrder());
        System.out.println("after : " + list);
    }
}
