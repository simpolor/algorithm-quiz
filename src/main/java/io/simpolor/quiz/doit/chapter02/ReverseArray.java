package io.simpolor.quiz.doit.chapter02;

import java.util.Scanner;

public class ReverseArray {

    static void swap(int[] a, int idx1, int idx2){
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    static void reverse(int[] a){
        for(int i=0; i<a.length/2; i++){
            swap(a, i, a.length - i - 1);
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("요솟수 수 : ");
        int num = scanner.nextInt();

        int[] x = new int[num];

        for(int i=0; i<num; i++){
            System.out.print("x["+i+"] : ");
            x[i] = scanner.nextInt();
        }

        reverse(x);

        System.out.println("이 요소를 역순으로 정렬합니다.");
        for(int i=0; i<num; i++){
            System.out.println("x["+i+"] = "+x[i]);

        }
    }


}
