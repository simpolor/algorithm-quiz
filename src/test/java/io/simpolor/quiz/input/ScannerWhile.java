package io.simpolor.quiz.input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerWhile {

    public static void main(String[] args) {

        // 입력 예
        Scanner in = null;
        int input = 0;
        while(true){
            try {
                System.out.print("정수를 입력해 주세요 : ");
                in = new Scanner(System.in);
                input = in.nextInt();
                break;
            }catch(InputMismatchException ime){
                System.out.println("-> 정수가 아닙니다.\n\n");
            }
        }
        in.close();

        // 출력 예제
        System.out.format("-> %d", input);


    }

}
