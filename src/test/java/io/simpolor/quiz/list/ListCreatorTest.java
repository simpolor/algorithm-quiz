package io.simpolor.quiz.list;

import org.junit.Test;

import java.util.*;

public class ListCreatorTest {

    @Test
    public void testNewArray_1(){

        List<String> list = new ArrayList<>();
        list.add("나봉수");
        list.add("라봉팔");
        list.add("김형희");
        list.add("하지민");

        System.out.println("after : "+list);
    }

    @Test
    public void testNewArray_2(){

        List<String> list = new ArrayList(){
            {
                add("나봉수");
                add("라봉팔");
                add("김형희");
                add("하지민");
            }
        };

        System.out.println("after : " + list);
    }

    @Test
    public void testNewArray_3(){

        List<String> list = new ArrayList<>(Arrays.asList("나봉수", "라봉팔", "김형희", "하지민"));

        System.out.println("after : " + list);
    }

    @Test
    public void testNewArray_4(){

        List<String> list = Arrays.asList(new String[]{"나봉수", "라봉팔", "김형희", "하지민"});

        System.out.println("after : " + list);
    }

    @Test
    public void testArraysAsList(){

        List<String> list = Arrays.asList("나봉수", "라봉팔", "김형희", "하지민");

        System.out.println("after : " + list);
    }

    @Test
    public void testCollections(){

        List<String> list = Collections.unmodifiableList(Arrays.asList("나봉수", "라봉팔", "김형희", "하지민"));

        System.out.println("after : " + list);

    }
}
