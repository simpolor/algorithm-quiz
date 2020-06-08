package io.simpolor.quiz.array;

import org.junit.Test;

import java.util.*;

public class ListCreatTest {


    @Test
    public void testNewArrayList(){

        List<String> array = new ArrayList<>();
        array.add("나봉수");
        array.add("라봉팔");
        array.add("김형희");
        array.add("하지민");

        System.out.println("array : "+array);
    }

    @Test
    public void testNewArrayList2(){

        List<String> array = new ArrayList(){
            {
                add("나봉수");
                add("라봉팔");
                add("김형희");
                add("하지민");
            }
        };

        System.out.println("array : "+array);
    }

    @Test
    public void testNewArrayListAsList(){

        List<String> array = new ArrayList<>(Arrays.asList("나봉수", "라봉팔", "김형희", "하지민"));

        System.out.println("array : "+array);
    }

    @Test
    public void testArraysAsListNewString(){

        List<String> array = Arrays.asList(new String[]{"나봉수", "라봉팔", "김형희", "하지민"});

        System.out.println("array : "+array);
    }

    @Test
    public void testArraysAsList(){

        // 초기화 이후 변경 불가한 리스트 만드는 방법
        List<String> array = Arrays.asList("나봉수", "라봉팔", "김형희", "하지민");
        System.out.println("array : "+array);
    }

    @Test
    public void testUnmodifiableList(){

        List<String> array = Arrays.asList(new String[]{"나봉수", "라봉팔", "김형희", "하지민"});
        List<String> unmodifiableList = Collections.unmodifiableList(array);

        System.out.println("array : "+unmodifiableList);
    }
}
