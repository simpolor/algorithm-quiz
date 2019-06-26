package io.simpolor.quiz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestTemplate {

    @Test
    public void test(){

        String input = "1A";

        System.out.println(Integer.parseInt(input, 16)) ;
        // 8진수를 구는 공식
        /**
         * int input = 108;
         * System.out.println(input % 8); // 4
         * System.out.println(input / 8); // 13
         * System.out.println(13 / 8); // 1
         * System.out.println(13 % 8); // 5
         * System.out.println(1 / 8); // 0
         * System.out.println(1 % 8); // 1
         */

        /// System.out.println(Integer.toOctalString(input));
        // System.out.println(Integer.toBinaryString(input));



    }
}
