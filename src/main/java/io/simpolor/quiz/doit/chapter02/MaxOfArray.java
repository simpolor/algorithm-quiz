package io.simpolor.quiz.doit.chapter02;

import java.util.Random;
import java.util.Scanner;

public class MaxOfArray {

    static int maxOf(int[] a){
        int max = a[0];
        for(int i=0; i<a.length; i++){
            if(max < a[i]) max = a[i];
        }
        return max;
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("키의 최댓값을 구합니다.");
        System.out.print("사람의 수 : ");
        int num = scanner.nextInt();

        int[] height = new int[num];

        System.out.println("키 값은 아래와 같습니다.");
        for(int i=0; i<num; i++){
            System.out.print("heighr["+i+"] : ");
            height[i] = scanner.nextInt();
        }

        System.out.println("최댓값은 "+maxOf(height)+"입니다.");
    }


}
