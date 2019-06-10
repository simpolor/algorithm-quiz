package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1020 {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 주민등록번호는 다음과 같이 구성된다.
     *
     * XXXXXX-XXXXXXX
     *
     * 앞의 6자리는 생년월일(yymmdd)이고 뒤 7자리는 성별, 지역, 오류검출코드이다.
     *
     * 주민등록번호를 입력받아 형태를 바꿔 출력해보자.
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * 주민등록번호 앞 6자리와 뒤 7자리가 "-"로 구분되어 입력된다.
     * 980907-1121112
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * "-"를 제외한 주민번호 13자리를 모두 붙여 출력한다.
     * 9809071121112
     *
     */
    public static void main(String[] args) {

        // 입력 예
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] strings = input.split("\\.");
        in.close();

        // 출력 예
        String year = String.format("%04d", Integer.parseInt(strings[0]));
        String month = String.format("%02d", Integer.parseInt(strings[1]));
        String day = String.format("%02d", Integer.parseInt(strings[2]));
        System.out.format("%s.%s.%s", year, month, day);

    }
}
