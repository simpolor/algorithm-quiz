package io.simpolor.quiz.doit.chapter06;

import java.util.Scanner;

public class SelectionSort {
    // a[indx1]와 a[index2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2){
        int t= a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 단순 선택 정렬
    static void selectionSort(int[] a, int n){
        for(int i=0; i<n-1; i++){
            int min = i;
            for(int j=i+1; j<n; j++){
                if(a[j] < a[min]){
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }


    public static void main(String[] ags){
        Scanner scanner = new Scanner(System.in);

        System.out.println("단순 선택 정렬");
        System.out.print("요솟수 : ");
        int nx = scanner.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++){
            System.out.print("x["+i+"] : ");
            x[i] = scanner.nextInt();
        }

        selectionSort(x, nx); // 배열 x를 버블 정렬합니다.

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0; i<nx; i++){
            System.out.println("x["+i+"] : "+x[i]);
        }
    }
}
