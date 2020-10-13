package io.simpolor.quiz.programmers.level01;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q_문자열_내림차순으로_배치하기 {

    /***
     * 문자열 내림차순으로 배치하기 ( 연습문제 )
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
     * s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
     *
     * ------------------------------
     * 제한 사항
     * ------------------------------
     * str은 길이 1 이상인 문자열입니다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * s	return
     * Zbcdefg	gfedcbZ
     *
     */
    public static void main(String[] args){

        String s = "Zbcdefg";

        Solution solution = new Solution();
        String result = solution.solution(s);

        System.out.println(result);
    }


    public static class Solution {
        public String solution(String s) {

            String[] strings = s.split("");

            Arrays.sort(strings, Collections.reverseOrder());

            StringBuilder stringBuilder = new StringBuilder();
            for(String s1 : strings){
                stringBuilder.append(s1);
            }

            return stringBuilder.toString();
        }
    }

    public static class Solution1 {
        public String solution(String s) {

            char[] sol = s.toCharArray();
            Arrays.sort(sol);
            return new StringBuilder(new String(sol)).reverse().toString();
        }
    }

    public static class Solution2 {
        public String solution(String s) {

            return Stream.of(s.split(""))
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.joining());
        }
    }

    public static class Solution3 {
        public String solution(String s) {

            List<String> strings = new ArrayList<>();
            for(int i=0; i<s.length(); i++){
                strings.add(String.valueOf(s.charAt(i)));
            }

            Collections.reverse(strings);

            String answer = "";
            for(String s1 : strings){
                answer += s1;
            }

            return answer;
        }
    }

    public static class Solution4 {
        public String solution(String s) {

            char[] ch = s.toCharArray();
            String lower = "";
            String upper = "";

            for(int i = 0; i < ch.length; i++) {
                int chnum = ch[i];

                if(chnum >= 65 && chnum <= 90)
                    upper += ch[i];
                else
                    lower += ch[i];
            }

            char[] chUpper = upper.toCharArray();
            char[] chLower = lower.toCharArray();
            upper = ""; lower = "";

            Arrays.sort(chUpper);
            Arrays.sort(chLower);

            for(int i = chUpper.length - 1; i >= 0; i--)
                upper += chUpper[i];
            for(int i = chLower.length - 1; i >= 0; i--)
                lower += chLower[i];

            return lower + upper;
        }
    }

    public static class Solution5 {
        public String solution(String s) {
            char[] chars = s.toCharArray();
            char temp =' ';

            for(int i = 0; i < s.length(); i++){
                for(int j = 0; j < s.length()-1 ; j++){
                    if( chars[j] < chars[j+1]){
                        temp = chars[j];
                        chars[j] = chars[j+1];
                        chars[j+1] = temp;
                    }
                }
            }
            s = new String(chars, 0, chars.length);
            return s;
        }
    }

    public static class Solution6 {
        public String solution(String s) {
            String answer = "";
            char[] crr = s.toCharArray();
            int length = crr.length;
            Arrays.sort(crr);
            for(int i = length-1; i >= 0; i--){
                answer += crr[i];
            }
            return answer;
        }
    }

    public static class Solution7 {
        public String solution(String s) {
            String answer = "";

            String smallString = "";
            String bigString = "";

            char[] sarray = s.toCharArray();
            for (char c:sarray) {
                int tmp = (int)c;

                if (tmp >= 65 && tmp <= 90) //대문자
                    bigString += c;
                if (tmp >= 97 && tmp <= 122) //소문자
                    smallString += c;
            }

            //System.out.println("bigString=" + bigString);
            //System.out.println("smallString=" + smallString);

            char[] smallarray = smallString.toCharArray();
            char[] bigarray = bigString.toCharArray();

            Arrays.sort(smallarray);
            Arrays.sort(bigarray);

            for (int i=0; i<bigarray.length; i++)
                answer = bigarray[i] + answer;
            for (int i=0; i<smallarray.length; i++)
                answer = smallarray[i] + answer;

            return answer;
        }
    }

}
