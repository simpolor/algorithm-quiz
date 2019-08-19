package io.simpolor.quiz.doit.chapter06;

import java.util.Scanner;

// 도수 정렬
public class Fsort {

    // 도수 정렬(0 이상 max 이하의 값을 입력합니다)
    static void fSort(int[] a, int n, int max){
        int[] f = new int [max + 1]; // 누적 도수
        int[] b = new int[n]; // 작업용 목적 배열

        // 1단계
        for(int i=0; i<n; i++){
            f[a[i]]++;
        }

        // 2단계
        for(int i=1; i<=max; i++){
            f[i] += f[i-1];
        }

        // 3단계
        for(int i=n-1; i>=0; i--){
            b[--f[a[i]]] = a[i];
        }

        // 4단계
        for(int i=0; i<n; i++){
            a[i] = b[i];
        }
    }

    public static void main(String[] ags){
        Scanner scanner = new Scanner(System.in);

        System.out.println("도수 정렬");
        System.out.print("요솟수 : ");
        int nx = scanner.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++){
            System.out.print("x["+i+"] : ");
            x[i] = scanner.nextInt();
        }

        // 배열 x의 최댓값을 구하여 max에 대입합니다.
        int max =x[0];
        for(int i=1; i<nx; i++){
            if(x[i] > max){
                max = x[i];
            }
        }

        fSort(x, nx, max); // 배열 x를 도수 정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0; i<nx; i++){
            System.out.println("x["+i+"] : "+x[i]);
        }
    }
}
