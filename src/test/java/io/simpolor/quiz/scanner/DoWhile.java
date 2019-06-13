package io.simpolor.quiz.scanner;

import java.util.Scanner;

public class DoWhile {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input = "";
        String[] output = null;
        do {
            System.out.println("\n1) 입력 값은 정수부가 100,000을 넘지않아야한다.\n2) 소수점 이하는 0으로 시작하지 않고, 6자리 이하여야 한다.");
            System.out.print("실수 입력 : ");
            input = scan.next();
            output = input.split("\\.");
        } while (Integer.parseInt(output[0]) > 100000 || output[1].length() > 6 || output[1].charAt(0) == '0');
        scan.close();

        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }


    }

}
