package io.simpolor.quiz.array;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayToListTest {

    @Test
    public void testArrayToList(){

        Integer[] strings = new Integer[]{1, 4, 6, 2, 5};

        List<Integer> list = Arrays.asList(strings);

        System.out.println(list);
    }

    @Test
    public void testArrayToArrayList(){

        Integer[] strings = new Integer[]{1, 4, 6, 2, 5};

        List<Integer> list = new ArrayList<>(Arrays.asList(strings));

        System.out.println(list);
    }

    @Test
    public void testArrayToArrayList1(){

        Integer[] strings = new Integer[]{1, 4, 6, 2, 5};

        List<Integer> list = new ArrayList<>(Arrays.stream(strings).collect(Collectors.toList()));

        System.out.println(list);
    }

}
