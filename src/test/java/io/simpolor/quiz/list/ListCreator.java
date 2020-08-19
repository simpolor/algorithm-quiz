package io.simpolor.quiz.list;

import java.util.*;

public class ListCreator {

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>();
        list1.add("나봉수");
        list1.add("라봉팔");
        list1.add("김형희");
        list1.add("하지민");
        System.out.println("list1 : "+list1);


        List<String> list2 = new ArrayList(){
            {
                add("나봉수");
                add("라봉팔");
                add("김형희");
                add("하지민");
            }
        };
        System.out.println("list2 : "+list2);


        List<String> list3 = new ArrayList<>(Arrays.asList("나봉수", "라봉팔", "김형희", "하지민"));
        System.out.println("list3 : "+list3);


        List<String> list4 = Arrays.asList(new String[]{"나봉수", "라봉팔", "김형희", "하지민"});
        System.out.println("list4 : "+list4);


        List<String> list5 = Arrays.asList("나봉수", "라봉팔", "김형희", "하지민");
        System.out.println("list5 : "+list5);


        List<String> unmodifiableList = Collections.unmodifiableList(Arrays.asList("나봉수", "라봉팔", "김형희", "하지민"));
        System.out.println("unmodifiableList : "+unmodifiableList);

    }
}
