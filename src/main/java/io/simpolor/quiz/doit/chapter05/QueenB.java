package io.simpolor.quiz.doit.chapter05;

import java.util.Scanner;

/***
 * 각 열에 1개의 퀸을 배치하는 조합을 재귀적으로 나열합니다.
 */
public class QueenB {

    static int[] pos = new int[8]; // 각 열의 쿤의 위치

    static void print(){
        for(int i=0; i<8; i++){
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }

    static void set(int i){
        for(int j=0; j<8; j++){
            pos[i] = j; // 퀸을 j행에 배치합니다.
            if(i == 7){ // 모든 열에 배치합니다.
                print();
            }else{
                set(i + 1); // 다음 열에 퀸을 배치합니다.
            }
        }
    }

    public static void main(String[] ags){
        set(0);
    }
}
