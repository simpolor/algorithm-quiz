package io.simpolor.quiz.array;

import org.junit.Test;

public class NewArrayTest {

    @Test
    public void testNewString(){

        String[] array = new String[]{"나봉수", "라봉팔", "김형희", "하지민"};

        for(String s : array){
            System.out.println(s);
        }
    }

    @Test
    public void testBrace(){

        String[] array = {"나봉수", "라봉팔", "김형희", "하지민"};

        for(String s : array){
            System.out.println(s);
        }
    }
}
