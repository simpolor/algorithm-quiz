package io.simpolor.quiz.programmers.level01;

import java.util.regex.Pattern;

public class Q_문자열_다루기_기본 {

    /***
     * 문자열 다루기 기본 ( 연습문제 )
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요.
     * 예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.
     *
     * ------------------------------
     * 제한 사항
     * ------------------------------
     * s는 길이 1 이상, 길이 8 이하인 문자열입니다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * s	return
     * a234	false
     * 1234	true
     *
     */
    public static void main(String[] args){

        // String s = "a234";
        String s = "1234";

        Solution solution = new Solution();
        boolean result = solution.solution(s);

        System.out.println(result);
    }


    public static class Solution {
        public boolean solution(String s) {

            if (s.length() != 4 && s.length() != 6) {
                return false;
            }

            char[] chars = s.toCharArray();
            for(char c : chars){
                if(!Character.isDigit(c)){
                    return false;
                }
            }

            return true;
        }
    }

    public static class Solution1 {
        public boolean solution(String s) {
            if(s.length() == 4 || s.length() == 6){
                try{
                    int x = Integer.parseInt(s);
                    return true;
                } catch(NumberFormatException e){
                    return false;
                }
            }
            else return false;
        }
    }

    public static class Solution2 {
        public boolean solution(String s) {
            if (s.length() == 4 || s.length() == 6) return s.matches("(^[0-9]*$)");
            return false;
        }
    }

    public static class Solution3 {
        public boolean solution(String s) {
            return (s.length() != 4 && s.length() != 6) || (s.split("[0-9]").length > 0) ? false:true;
        }
    }

    public static class Solution4 {
        public boolean solution(String s) {
            if (!(s.length() == 4 || s.length() == 6))
                return false;

            return Pattern.matches("[0-9]+", s);
        }
    }

    public static class Solution5 {
        public boolean solution(String s) {
            boolean answer = false;

            if(s.length() == 4 || s.length() == 6){
                char[] arr = s.toCharArray();

                for(int i = 0; i < arr.length; i++){
                    if(arr[i] < '0' || arr[i] > '9'){
                        answer = false;
                        break;
                    }else
                        answer = true;
                }
            }

            return answer;
        }
    }

    public static class Solution6 {
        public boolean solution(String s) {
            int length = s.length();
            if (length == 4 || length == 6) {
                for (int i = 0; i < length; ++i) {
                    char c = s.charAt(i);
                    if (c < 48 || c > 57) {
                        return false;
                    }
                }
                return true;
            } else
                return false;
        }
    }

    public static class Solution7 {
        public boolean solution(String s) {
            boolean answer = true;

            char[] chararray = s.toCharArray();

            if (s.length() != 4 && s.length() != 6)
                answer = false;

            String num = "0123456789";

            for (char c:chararray) {
                if (!num.contains(Character.toString(c))) {
                    answer = false;
                    break;
                }
            }

            return answer;
        }
    }

}
