package io.simpolor.quiz.doit.chapter06;

import java.util.Scanner;

public class InsertionSort {

    // 단순 삽입 정렬
    static void insertionSort(int[] a, int n){
        for(int i=1; i<n; i++){
            int j;
            int tmp = a[i];
            for(j=i; j>0 && a[j-1] > tmp; j--){
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }


    public static void main(String[] ags){
        Scanner scanner = new Scanner(System.in);

        System.out.println("단순 삽입 정렬");
        System.out.print("요솟수 : ");
        int nx = scanner.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++){
            System.out.print("x["+i+"] : ");
            x[i] = scanner.nextInt();
        }

        insertionSort(x, nx); // 배열 x를 버블 정렬합니다.

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0; i<nx; i++){
            System.out.println("x["+i+"] : "+x[i]);
        }
    }
}
