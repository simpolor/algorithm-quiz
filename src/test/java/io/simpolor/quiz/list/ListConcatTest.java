package io.simpolor.quiz.list;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.ListUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListConcatTest {

    @Test
    public void testAddAll(){

        List<String> list1 = Arrays.asList("나봉수", "라봉팔");
        List<String> list2 = Arrays.asList("김형희", "하지민");
        System.out.println("before1 : "+list1+" / before2 : "+list2);

        List<String> concatList = new ArrayList<>();
        concatList.addAll(list1);
        concatList.addAll(list2);
        System.out.println("after :  "+concatList);
    }

    @Test
    public void testListUtilsByUnion(){

        List<String> list1 = Arrays.asList("나봉수", "라봉팔");
        List<String> list2 = Arrays.asList("김형희", "하지민");
        System.out.println("before1 : "+list1+" / before2 : "+list2);

        List<String> concatList = ListUtils.union(list1, list2);
        System.out.println("after : "+concatList);
    }

    @Test
    public void testGuavaByIterables(){

        List<String> list1 = Arrays.asList("나봉수", "라봉팔");
        List<String> list2 = Arrays.asList("김형희", "하지민");
        System.out.println("before1 : "+list1+" / before2 : "+list2);

        Iterable<String> joinedIterable = Iterables.unmodifiableIterable(Iterables.concat(list1, list2));
        List<String> concatList = Lists.newArrayList(joinedIterable);
        System.out.println("after : "+concatList);
    }

    @Test
    public void testStreamByStreamConcat(){

        List<String> list1 = Arrays.asList("나봉수", "라봉팔");
        List<String> list2 = Arrays.asList("김형희", "하지민");
        System.out.println("before1 : "+list1+" / before2 : "+list2);

        List<String> concatList = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
        System.out.println("after : "+concatList);
    }
}
