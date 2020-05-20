package io.simpolor.quiz.programmers.inquiry;

import java.util.*;

/***
 * 카펫
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
 *
 * carpet.png
 * ㅁㅁㅁㅁ
 * ㅁㅌㅌㅁ
 * ㅁㅁㅁㅁ
 *
 * ㅁ : brown
 * E : yellow
 *
 * Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
 *
 * Leo가 본 카펫에서 갈색 격자의 수 brown,
 * 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로,
 * 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 * 갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
 * 노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
 * 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * brown	yellow	return
 * 10	2	[4, 3]
 * 8	1	[3, 3]
 * 24	24	[8, 6]
 *
 *
 * ㅁㅁㅁㅁ ㅁㅁㅁ ㅁㅁㅁㅁㅁㅁㅁㅁ
 * ㅁㅌㅌㅁ ㅁㅌㅁ ㅁㅌㅌㅌㅌㅌㅌㅁ
 * ㅁㅁㅁㅁ ㅁㅁㅁ ㅁㅌㅌㅌㅌㅌㅌㅁ
 *             ㅁㅌㅌㅌㅌㅌㅌㅁ
 *             ㅁㅌㅌㅌㅌㅌㅌㅁ
 *             ㅁㅁㅁㅁㅁㅁㅁㅁ
 *
 * 출처
 *
 * ※ 공지 - 2020년 2월 3일 테스트케이스가 추가되었습니다.
 * ※ 공지 - 2020년 5월 11일 웹접근성을 고려하여 빨간색을 노란색으로 수정하였습니다.
 *
 */
public class INQUIRY004 {

    public static void main(String[] args) {

        int brown = 10;
        int yellow = 2;

        Solution solution = new Solution();
        int[] result = solution.solution(brown, yellow);

        System.out.println(Arrays.toString(result));
    }

    public static class Solution {
        public int[] solution(int brown, int red) {
            int a = (brown+4)/2;
            int b = red+2*a-4;
            int[] answer = {(int)(a+Math.sqrt(a*a-4*b))/2,(int)(a-Math.sqrt(a*a-4*b))/2};

            return answer;
        }
    }

    public static class Solution1 {
        public int[] solution(int brown, int red) {
            int[] answer = {};
            answer = new int[2];
            int iAllNum = brown + red;
            int iHeight = 0;

            for (int iBrownWidth = 1; iBrownWidth < brown; iBrownWidth++) {
                iHeight = iAllNum/iBrownWidth;

                if((iBrownWidth-2)*(iHeight-2) == red) {
                    answer[0] = iBrownWidth;
                    answer[1] = iHeight;
                }
            }
            return answer;
        }
    }

    public static class Solution2 {
        public int[] solution(int brown, int red) {
            int n = brown + red;
            List<Integer> list = new ArrayList<Integer>();

            for(int i = 2; i <= Math.sqrt(n); i++){
                if(n % i == 0){
                    list.add(i);
                    int quotient = n/i;
                    if(i != quotient) list.add(quotient);
                }
            }

            Collections.sort(list);

            int col = 0;
            int row = 0;

            for(int i : list)
                if((col = i) >= (row = (n/i))){
                    if((col + col + row - 2 + row - 2) == brown) break;
                }

            return new int[]{col, row};
        }
    }

    public static class Solution3 {
        public int[] solution(int brown, int red) {
            int[] answer = {};

            int size = (brown - 4) / 2;
            int w = size % 2 == 0 ? size / 2 : size / 2 + 1, h = size - w;

            while(h >= 1) {
                if(w * h == red) {
                    answer = new int[]{w + 2, h + 2};
                    break;
                }
                w++;
                h--;

            }
            return answer;
        }
    }

    public static class Solution4 {
        public int [] solution(int brown, int red){
            int [] answer = new int[2];
            int n = brown / 2 + 2; // 가로세로의 총 길이는 brown / 2 + 2
            int length = n - 1, width = n - length; // length: 가로, width: 세로
            while(length >= width){
                int temp = (length - 2) * (width - 2);
                if(temp == red) {
                    answer[0] = length;
                    answer[1] = width;
                    break;
                }
                length -= 1;
                width += 1;
            }
            return answer;
        }
    }

    public static class Solution5 {
        public int[] solution(int brown, int red) {
            int x=0,y=0;
            for(y=1;y<=red;y++) {
                x=red/y;
                if(y*x!=red){
                    continue;
                }

                if((x+y)==((brown/2)-2)) {
                    break;
                }

            }

            int[] answer = {x+2,y+2};
            return answer;
        }
    }


}
