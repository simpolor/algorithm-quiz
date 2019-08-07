package io.simpolor.quiz.doit.chapter06;

import java.util.Scanner;

// 퀵 정렬(배열을 나누는 과정을 출력합니다.)
public class QuickSort1 {

    // a[indx1]와 a[index2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2){
        int t= a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 퀵 정렬
    static void quickSort(int[] a, int left, int right){
        int pl = left; // 왼쪽 커서
        int pr = right; // 오른쪽 커서
        int x = a[(pl + pr) / 2]; // 피벗

        System.out.printf("a[%d] ~ a[%d] : {", left, right);
        for(int i=left; i<right; i++){
            System.out.printf("%d, ", a[i]);
        }
        System.out.printf("%d}\n", a[right]);

        do{
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;
            if(pl <= pr){
                swap(a, pl++, pr--);
            }
        }while(pl <= pr);


        if(left < pr){
            quickSort(a, left, pr);
        }

        if(pl < right){
            quickSort(a, pl, right);
        }
    }

    public static void main(String[] ags){
        Scanner scanner = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요솟수 : ");
        int nx = scanner.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++){
            System.out.print("x["+i+"] : ");
            x[i] = scanner.nextInt();
        }

        quickSort(x, 0, nx-1); // 배열 x를 버블 정렬합니다.

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0; i<nx; i++){
            System.out.println("x["+i+"] : "+x[i]);
        }
    }
}
