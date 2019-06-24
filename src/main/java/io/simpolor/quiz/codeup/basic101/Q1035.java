package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1035 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 16진수로 입력된 정수 한 개를 8진수로 바꾸어 출력하는 프로그램을 작성해보자.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 16진수 한 개가 입력된다.
     * (단, 16진수는 숫자 및 영문 소문자로 입력된다.)
     *
     * f
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 입력 받은 16진수를 8진수로 바꾸어 출력한다.
     *
     * 17
     *
     */
    public static void main(String[] args) {

        /*
        // 입력 예
        int input = scan.nextInt(16);
        scan.close();

        // 출력 예
        System.out.println(Integer.toOctalString(input));
        */

        // 입력 예
        Scanner in = in = new Scanner(System.in);
        String input = in.next();
        in.close();

        // 출력 예
        String[] hex = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        String[] changer = new String[]{"1", "2", "4", "8"};

        char[] chars = replaceChars(input);
        for(int i=0; i<chars.length; i++){
            System.out.println(chars[i]);
        }

       /* int[] bin = new int[]{};
        do {
            bin = addInt(bin, input % 16);
            input = input / 16;
        } while (input != 0);

        for (int i = bin.length - 1; 0 <= i; i--) {
            System.out.print(hex[bin[i]]);
        }*/
    }

    public static int[] addInt(int[] nums, int addNum){

        int[] newNums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++){
            newNums[i] = nums[i];
        }
        newNums[newNums.length - 1] = addNum;

        return newNums;
    }

    public static char[] replaceChars(String text){
        char[] chars = new char[text.length()];
        for(int i=0; i<text.length(); i++){
            chars[i] = text.charAt(i);
        }
        return chars;
    }

}