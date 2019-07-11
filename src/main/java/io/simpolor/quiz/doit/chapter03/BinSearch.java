package io.simpolor.quiz.doit.chapter03;

import java.util.Scanner;

public class BinSearch {

    // 요솟수 n인 배열 a에서 key와 같은 요소를 이진 검색합니다.
    static int binSearch(int[] a, int n, int key){
        int pl = 0; // 검색 범위의 첫 인덱스
        int pr = n - 1; // 검색 범위의 끝 인덱스

        do {
           int pc = (pl + pr) / 2; // 중앙 요소의 인덱스
            if(a[pc] == key){ // 검색 성공
                return pc;
            }else if(a[pc] <key){ // 검색 범위를 뒤쪽 절반으로 좁힙
                pl = pc + 1;
            }else{
                pr = pc - 1; // 검색 범위를 앞쪽 절반으로 좁힙
            }
        } while (pl <= pr);

        return -1; // 검색 실패
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = scanner.nextInt();
        int[] x = new int[num]; // 요솟수가 num인 배열

        System.out.println("어름차순으로 입력하세요.");

        System.out.print("x[0] : ");
        x[0] = scanner.nextInt();

        for(int i=1; i<num; i++){
            do{
                System.out.print("x["+i+"] : ");
                x[i] = scanner.nextInt();
            }while (x[i] < x[i -1]);
        }

        System.out.print("검색할 값 : ");
        int key = scanner.nextInt();

        int idx = binSearch(x, num, key);

        if(idx == -1){
            System.out.println("그 값의 요소가 없습니다.");
        }else{
            System.out.println(key+"은((는) x["+idx+"]에 있습니다.");
        }
    }
}
