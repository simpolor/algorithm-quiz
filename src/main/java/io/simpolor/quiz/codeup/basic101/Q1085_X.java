package io.simpolor.quiz.codeup.basic101;

import java.util.Scanner;

public class Q1085_X {

    /***
     * ----------------------------
     * 문제 설명
     * ----------------------------
     * 소리가 컴퓨터에 저장될 때에는 디지털 데이터화 되어 저장된다.
     *
     * 마이크를 통해 1초에 적게는 수십 번, 많게는 수만 번 소리의 강약을 체크해
     * 그 값을 정수값으로 바꾸고, 그 값을 저장해 소리를 파일로 저장할 수 있다.
     *
     * 값을 저장할 때에는 비트를 사용하는 정도에 따라 세세한 녹음 정도를 결정할 수 있고,
     * 좌우(스테레오) 채널로 저장하면 2배… 5.1채널이면 6배의 저장공간이 필요하고,
     * 녹음 시간이 길면 그 만큼 더 많은 저장공간이 필요하다.
     *
     * 1초 동안 마이크로 소리강약을 체크하는 수를 h
     * (헤르쯔, Hz 는 1초에 몇 번? 체크하는가를 의미한다.)
     *
     * 한 번 체크한 결과를 저장하는 비트 b
     * (2비트를 사용하면 0 또는 1 두 가지, 16비트를 사용하면 65536가지..)
     *
     * 좌우 등 소리를 저장할 트랙 개수인 채널 c
     * (모노는 1개, 스테레오는 2개의 트랙으로 저장함을 의미한다.)
     *
     * 녹음할 시간 s가 주어질 때,
     *
     * 필요한 저장 용량을 계산하는 프로그램을 작성해보자.
     *
     * 실제로 일반적인 CD 음질(44.1KHz, 16bit, 스테레오)로 1초 동안 저장하려면
     * 44100 * 16 * 2 * 1 bit의 저장공간이 필요하다.
     *
     * 이렇게 녹음하는 방식을 PCM(Pulse Code Modulation) 방법이라고 하는데,
     * 압축하지 않은 순수한(raw) 소리 데이터 파일은 대표적으로 *.wav 가 있다.
     *
     * **
     *       8 bit(비트)           = 1byte(바이트)     //       8bit=1Byte
     * 1024 Byte(210 byte) = 1KB(킬로 바이트) // 1024bit=1KB
     * 1024 KB(210 KB)      = 1MB(메가 바이트)
     * 1024 MB(210 MB)     = 1GB(기가 바이트)
     * 1024 GB(210 GB)      = 1TB(테라 바이트)
     *
     * ----------------------------
     * 입력
     * ----------------------------
     * h, b, c, s 가 공백을 두고 입력된다.
     * h는 48,000이하, b는 32이하(단, 8의배수), c는 5이하, s는 6,000이하의 자연수이다.
     *
     * 44100 16 2 10
     *
     * ----------------------------
     * 출력
     * ----------------------------
     * 필요한 저장 공간을 MB 단위로 바꾸어 출력한다.
     * 단, 소수점 둘째 자리에서 반올림해 첫째 자리까지 출력하고 MB를 공백을 두고 출력한다.
     *
     * 1.7 MB
     *
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt(); // Hz
        int b = scanner.nextInt(); // save
        int c = scanner.nextInt(); // channel
        int s = scanner.nextInt(); // time
        scanner.close();

        String[] unit = new String[]{"", "KB", "MB", "GB", "TB"};

        int bit = 8;
        int cal = (h * b * c * s) / bit;

        int count = 0;
        int div = 1024;
        int mok = 0;

        int result = cal / div;
        System.out.println("result : "+result);

        while(result > div){
            mok = result % div;
            result = result / div;
            count++;

            break;
        }

        System.out.println(result+"."+mok+" "+unit[count]);
    }
}
