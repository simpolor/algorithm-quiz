package io.simpolor.quiz.replace;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Conversion {

    public static void main(String[] args) {

        Object hex[] = {0,1,2,3,4,5,6,7,8,9,"A","B","C","D","E","F"};
        Object ans[] = new Object[30];
        int cnt=0; // 배열의 자리수
        int dec,rad; // 변환할 10진수, 변환될 진수
        int mok,na; // 몫, 나머지
        int print; // 출력을 위한 변수

        Scanner scan = null;

        while(true){
            try{
                scan = new Scanner(System.in);
                System.out.print("10진수를 입력하세요. : ");
                dec = scan.nextInt();
                print = dec;
                break;
            }catch(InputMismatchException ex){
                System.out.println("숫자만 입력해야 합니다.");
            }
        }

        while(true){
            try{
                scan = new Scanner(System.in);
                System.out.println("2,8,16진수 중에서");
                System.out.print("변환하고싶은 진수를 입력하세요. : ");
                rad = scan.nextInt();
                if(rad == 2 || rad == 8 || rad ==16){
                    break;
                }else{
                    System.out.println("2,8,16진수만 입력해야 합니다.");
                }
            }catch(InputMismatchException ex){
                System.out.println("숫자만 입력해야 합니다.");
            }
        }
        scan.close();

        int weg = 1; // 가중치
        while(weg <= dec){
            weg = weg * rad; // ex) dec가 13, rad가 2일 경우 가중치를 2, 4, 8, 16까지 만들어줌
        }

        while(weg>1){ // 가중치가 1이 될 때까지 반복
            weg = weg / rad; // ex) 13=8+4+1 이므로 8부터 시작하도록 한다.
            mok = dec / weg; // 10진수를 나눈 몫만큼 배열에 저장하기 위해
            na = dec - mok * weg; // dec%weg //다음 싸이클을 실행하기 위한 나머지
            if(mok>10){
                ans[cnt] = hex[mok]; // 16진수일 경우 10이상이면 A~F를 넣어주기
            }else{
                ans[cnt] = mok; // 몫을 배열에 넣어준다
            }
            cnt++; // 다음 자리수로 이동
            dec = na; // 입력한 10진수에 나머지를 넣어준다(다음 자리수로 넘어가기)
        }

        System.out.print(print+"(10) = ");
        for(int i=0;i<cnt;i++){
            System.out.print(ans[i]);
        }

        if(rad == 2){ //2진수 변환 출력
            System.out.println("(2)");
        }else if(rad == 8){ //8진수 변환 출력
            System.out.println("(8)");
        }else{ // 16진수 변환 출력
            System.out.println("(16)");
        }

    }

}
