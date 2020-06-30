package io.simpolor.quiz.list;

import org.junit.Test;

import java.util.*;

public class ListToArrayTest {

    @Test
    public void testListToArray(){

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(6);
        list.add(2);
        list.add(5);

        int[] array = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            array[i] = list.get(i);
        }

        System.out.println(Arrays.toString(array));

    }
}
