package io.simpolor.quiz.doit.chapter05;

/***
 * 8퀸 문제 풀이
 */
public class EightQueen {

    static boolean[] flagA = new boolean[8]; // 각 행에 퀸을 배치했는지 체크
    static boolean[] flagB = new boolean[15]; // 우위로 대각선 방향으로 퀸을 배치했는지 체크
    static boolean[] flagC = new boolean[15]; // 우아래 대각선 방향으로 퀸을 배치했는지 체크
    static int[] pos = new int[8]; // 각 열의 쿤의 위치

    // 각 열의 퀸의 위치를 출력
    static void print(){
        for(int i=0; i<8; i++){
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }

    // i열의 알맞는 위치에 퀸을 배치
    static void set(int i){
        for(int j=0; j<8; j++){
            if(flagA[j] == false && flagB[i+j] == false && flagC[i-j+7] == false){
                pos[i] = j;
                if(i == 7){
                    print();
                }else{
                    flagA[j] = flagB[i+j] = flagC[i-j+7] = true;
                    set(i + 1);
                    flagA[j] = flagB[i+j] = flagC[i-j+7] = false;
                }
            }
        }
    }

    public static void main(String[] ags){
        set(0);
    }
}
