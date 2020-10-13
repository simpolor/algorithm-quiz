package io.simpolor.quiz.scanner;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerDoWhileTest {

    public static void main(String[] args) {

        String input;
        String[] output;

        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("\n1) 입력 값은 정수부가 100,000을 넘지않아야한다.\n2) 소수점 이하는 0으로 시작하지 않고, 6자리 이하여야 한다.");
            System.out.print("실수 입력 : ");
            input = scanner.next();
            output = input.split("\\.");

        } while (Integer.parseInt(output[0]) > 100000 || output[1].length() > 6 || output[1].charAt(0) == '0');

        scanner.close();


        System.out.println("입력한 소수 : "+Arrays.toString(output));
    }

}
