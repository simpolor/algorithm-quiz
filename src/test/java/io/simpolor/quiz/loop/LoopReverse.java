package io.simpolor.quiz.loop;

public class LoopReverse {

    public static void main(String[] args) {

        String input = "simpolor";
        char[] array = input.toCharArray();

        for(char c : array){
            System.out.print(c);
        }

        System.out.println("");

        for(int i=array.length-1; 0<=i; i--){
            System.out.print(array[i]);
        }


    }
}
