package io.simpolor.quiz.scanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerWhileTest {

    public static void main(String[] args) {

        int input;

        Scanner scanner;
        while(true){
            try {
                System.out.print("정수를 입력해 주세요 : ");
                scanner = new Scanner(System.in);
                input = scanner.nextInt();
                break;

            }catch(InputMismatchException ime){
                System.out.println("-> 정수가 아닙니다.\n\n");
            }
        }
        scanner.close();


        System.out.println("input : "+input);
    }

}
