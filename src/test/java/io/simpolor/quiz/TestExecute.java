package io.simpolor.quiz;

import org.junit.Test;

import java.util.*;

public class TestExecute {

    @Test
    public void test(){

        int a = 321, c = 0, d = 0;
        while (a != 0){
            // System.out.println(a);
            c = a % 10;
            // 핵심은 처음 d가 0이기때문에 한자리로 시작
            d = (d * 10) + c;
            System.out.println(d);

            a = a / 10;
        }
    }
}
