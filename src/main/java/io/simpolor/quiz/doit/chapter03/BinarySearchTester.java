package io.simpolor.quiz.doit.chapter03;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTester {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = scanner.nextInt();
        int[] x = new int[num]; // 요솟수가 num인 배열

        System.out.println("어름차순으로 입력하세요.");

        System.out.print("x[0] : ");
        x[0] = scanner.nextInt();

        for(int i=1; i<num; i++){
            do{
                System.out.print("x["+i+"] : ");
                x[i] = scanner.nextInt();
            }while (x[i] < x[i -1]);
        }

        System.out.print("검색할 값 : ");
        int key = scanner.nextInt();

        int idx = Arrays.binarySearch(x, key);

        if(idx == -1){
            System.out.println("그 값의 요소가 없습니다.");
        }else{
            System.out.println(key+"은((는) x["+idx+"]에 있습니다.");
        }
    }
}
