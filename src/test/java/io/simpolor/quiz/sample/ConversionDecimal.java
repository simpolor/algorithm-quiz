package io.simpolor.quiz.sample;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ConversionDecimal {

    @Test
    public void testDemicalToBinary() {

        int input = 108;
        System.out.println(Integer.toBinaryString(input));
        System.out.println("");

        List<Integer> list = new ArrayList();
        do {
            list.add(input % 2);
            input = input / 2;
        }while (input != 0);

        for(int i=list.size()-1; 0<=i; i--){
            System.out.print(list.get(i));
        }
    }

    @Test
    public void testDemicalToOctal() {

        int input = 108;
        System.out.println(Integer.toOctalString(input));
        System.out.println("");

        List<Integer> list = new ArrayList();
        do {
            list.add(input % 8);
            input = input / 8;
        }while (input != 0);

        for(int i=list.size()-1; 0<=i; i--){
            System.out.print(list.get(i));
        }
    }

    @Test
    public void testDemicalToHex() {

        int input = 108;
        System.out.println(Integer.toHexString(input));
        System.out.println("");

        String[] hex = new String[]{"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        List<Integer> list = new ArrayList();
        do {
            list.add(input % 16);
            input = input / 16;
        }while (input != 0);

        for(int i=list.size()-1; 0<=i; i--){
            System.out.print(hex[list.get(i)]);
        }
    }

}
