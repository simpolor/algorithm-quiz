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
        // String[] hex = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        /*char[] hex = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};

        for(int i=0; i<chars.length; i++){
            if(48 <= (int)chars[i] && (int)chars[i] <= 57){
                System.out.println("숫자 : "+(int)chars[i]);
            }else if(65 <= (int)chars[i] && (int)chars[i] <= 70){
                System.out.println("영문 : "+(int)chars[i]);
            }
            System.out.println(chars[i]);
        }*/

        int gob = 1;
        int sum = 0;

        char[] chars = replaceChars(input);
        for(int i=chars.length-1; i>=0; i--){

            int plus = 0;
            //if(){
            //    plus = 1;
            //}else{

           // }
            sum = sum + Character.getNumericValue(chars[i]) * gob;
            gob = gob * 16;
        }
        System.out.println(sum);

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