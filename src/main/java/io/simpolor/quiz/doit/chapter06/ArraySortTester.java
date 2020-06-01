package io.simpolor.quiz.doit.chapter06;

import java.util.Arrays;
import java.util.Scanner;

// Arrays.sort_04 메서드를 사용하여 정렬합니다.(퀵 정렬)
public class ArraySortTester {

    public static void main(String[] ags){
        Scanner scanner = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = scanner.nextInt();
        int[] x = new int[num];

        for(int i=0; i<num; i++){
            System.out.print("x["+i+"] : ");
            x[i] = scanner.nextInt();
        }

        Arrays.sort(x); // 배열 x를 정렬합니다.

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0; i<num; i++){
            System.out.println("x["+i+"] : "+x[i]);
        }
    }
}
