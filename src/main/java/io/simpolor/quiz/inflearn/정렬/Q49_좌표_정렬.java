package io.simpolor.quiz.inflearn.정렬;

import java.util.*;

public class Q49_좌표_정렬 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            arr.add(new Point(x, y));
        }

        Collections.sort(arr);

        for(Point point : arr){
            System.out.println(point.x + " " + point.y);
        }

    }

    // 컬렉션 프레임워크 정렬을 사용하기 위한 Comparable 정렬 관련 인터페이스
    public static class Point implements Comparable<Point> {

        public int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        // 비교시 this 앞, o가 매개변수 비교
        // 오름 차순 정렬은 음수가 리턴
        @Override
        public int compareTo(Point o) {
            if(this.x == o.x){
                return this.y - o.y;
            }

            return this.x - o.x;
        }
    }
}
