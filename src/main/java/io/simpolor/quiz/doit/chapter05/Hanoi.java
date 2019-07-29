package io.simpolor.quiz.doit.chapter05;

import java.util.Scanner;

public class Hanoi {

    static void move(int no,int x, int y){
        if(no > 1){
            move(x - 1, x, 6 - x - y);
        }
        System.out.println("원반["+no+"]을 "+x+"기둥에서 "+y+"기둥으로 옮김");

        if(no > 1){
            move(no - 1, 6 - x - y, y);
        }
    }

    public static void main(String[] ags){
        Scanner scanner = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반 개수 : ");
        int n = scanner.nextInt();

        move(n, 1, 3); // 1번의 기둥의 n개의 원번을 3번 기둥으로 옮김
    }
}
