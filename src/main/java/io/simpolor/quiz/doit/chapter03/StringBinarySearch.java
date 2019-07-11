package io.simpolor.quiz.doit.chapter03;

import java.util.Arrays;
import java.util.Scanner;

public class StringBinarySearch {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // 자바에서 사용하는 키워드입니다.
        String[] x = {
                "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const"
                , "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float"
                , "for", "goto", "if", "impletements", "import", "instanceof", "init", "interface", "long", "native"
                , "new", "pakage", "private", "protected", "public", "return", "short", "static", "protected", "public"
                , "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"
        };

        System.out.print("원하는 키워드를 입력하세요 : "); // 키 값을 입력

        String key = scanner.next();

        int idx = Arrays.binarySearch(x, key);

        if(idx < 0){
            System.out.println("해당 키워드가 없습니다.");
        }else{
            System.out.println("해당 키워드는 x["+idx+"]에 있습니다.");
        }
    }
}
