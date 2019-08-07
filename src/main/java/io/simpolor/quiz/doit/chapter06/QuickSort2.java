package io.simpolor.quiz.doit.chapter06;

import io.simpolor.quiz.doit.chapter04.IntStack;

import java.util.Scanner;

// 퀵 정렬(비재귀 버전)
public class QuickSort2 {

    // a[indx1]와 a[index2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2){
        int t= a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 퀵 정렬
    static void quickSort(int[] a, int left, int right){
        IntStack lsStack = new IntStack(right - left + 1); // 스택 생성
        IntStack rsStack = new IntStack(right - left + 1);

        lsStack.push(left);
        rsStack.push(right);

        while (lsStack.isEmpty() != true){
            int pl = left = lsStack.pop(); // 왼쪽 커서
            int pr = right = rsStack.pop(); // 오픈쪽 커서
            int x = a[(left + right) / 2]; // 피벗

            do {
                while (a[pl] < x) pl ++;
                while (a[pr] > x) pr --;
                if(pl <= pr){
                    swap(a, pl++, pr--);
                }
            } while (pl <= pr);

            if(left < pr){
                lsStack.push(left); // 왼쪽 그룹 범위의
                rsStack.push(pr); // 인덱스를 푸시합니다.
            }

            if(pl < right){
                lsStack.push(pl); // 오픈쪽 그룹 범위의
                rsStack.push(right); // 인덱스를 푸시합니다.

            }
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
