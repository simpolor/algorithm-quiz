package io.simpolor.quiz.programmers.level01;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Q1015 {

    /***
     * 서울에서 김서방 찾기
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * String형 배열 seoul의 element중 Kim의 위치 x를 찾아,
     * 김서방은 x에 있다는 String을 반환하는 함수, solution을 완성하세요.
     * seoul에 Kim은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.
     *
     * ------------------------------
     * 제한 사항
     * ------------------------------
     * seoul은 길이 1 이상, 1000 이하인 배열입니다.
     * seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
     * Kim은 반드시 seoul 안에 포함되어 있습니다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * seoul	return
     * [Jane, Kim]	김서방은 1에 있다
     *
     */
    public static void main(String[] args){

        String[] seoul = new String[]{"Jane", "Kim"};

        Solution solution = new Solution();
        String result = solution.solution(seoul);

        System.out.println(result);
    }


    public static class Solution {
        public String solution(String[] seoul) {

            String keyword = "Kim";
            for(int i=0; i<seoul.length; i++){
                if(keyword.equals(seoul[i])){
                    return "김서방은 "+i+"에 있다";
                }
            }

            return "";
        }
    }

    public static class Solution1{
        public String solution(String[] seoul) {

            //x에 김서방의 위치를 저장하세요.
            int x = Arrays.asList(seoul).indexOf("Kim");

            return "김서방은 "+ x + "에 있다";
        }
    }

    public static class Solution2{
        public String solution(String[] seoul) {

            int x = 0;
            while(x<seoul.length){
                if(seoul[x] == "Kim")
                    break;
                else x++;
            }

            return "김서방은 "+ x + "에 있다";
        }
    }

    public static class Solution3 {
        public String solution(String[] seoul) {
            StringBuilder sb = new StringBuilder();

            int idx = 0;
            for(String element : seoul){
                if("Kim".equals(element)){
                    break;
                }
                idx++;
            }
            sb.append("김서방은 ");
            sb.append(idx);
            sb.append("에 있다");

            return sb.toString();
        }
    }

}
