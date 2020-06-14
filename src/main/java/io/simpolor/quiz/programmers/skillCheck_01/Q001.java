package io.simpolor.quiz.programmers.skillCheck_01;

public class Q001 {


    /***
     * 시저 암호
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
     * 예를 들어 AB는 1만큼 밀면 BC가 되고, 3만큼 밀면 DE가 됩니다. z는 1만큼 밀면 a가 됩니다.
     * 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
     *
     * ------------------------------
     * 제한 조건
     * ------------------------------
     * 공백은 아무리 밀어도 공백입니다.
     * s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
     * s의 길이는 8000 이하입니다.
     * n은 1 이상, 25 이하인 자연수입니다.
     */
    public static void main(String[] args) {

        String s = "AB";
        int n = 1;

        Solution solution = new Solution();
        String result = solution.solution(s, n);

        System.out.println(result);
    }

    public static class Solution {
        public String solution(String s, int n) {

            String result = "";

            n = n % 26; // 알파뱃이 26개 인것을 인지
            for (int i = 0; i < s.length(); i++) {

                char ch = s.charAt(i); // String 문자열을 char 로 한글자씩 가져옴

                // char -> int 로 변경하여 A(65), a(97)를 더한 n 값을 더한 후 계산
                // 26을 나눠 나머지 증가값을 구할 수 있음
                if (Character.isLowerCase(ch)) {
                    ch = (char) ((ch - 'a' + n) % 26 + 'a');
                } else if (Character.isUpperCase(ch)) {
                    ch = (char) ((ch - 'A' + n) % 26 + 'A');
                }
                result += ch;
            }
            return result;
        }
    }



    public static class Solution1 {
        public String solution(String s, int n) {

            String answer = "";

            int z = (int) 'z';
            int Z = (int) 'Z';
            int a = (int) 'a';
            int A = (int) 'A';

            char[] temp = s.toCharArray();

            for (int i = 0; i < temp.length; i++) {

                if (temp[i] >= a && temp[i] <= z) {
                    //소문자인경우
                    temp[i] = (int) temp[i] + n > z ? (char) (a + (int) temp[i] + n - z - 1) : (char) ((int) temp[i] + n);
                } else if (temp[i] >= A && temp[i] <= Z) {
                    //대문자인경우
                    temp[i] = (int) temp[i] + n > Z ? (char) (A + (int) temp[i] + n - Z - 1) : (char) ((int) temp[i] + n);
                } else {
                    //공백
                    temp[i] = temp[i];
                }
            }
            answer = new String(temp);

            return answer;
        }
    }

    public static class Solution2 {
        public String solution(String s, int _n) {
            return s.chars().map(c -> {
                int n = _n % 26;
                if (c >= 'a' && c <= 'z') {
                    return 'a' + (c - 'a' + n) % 26;
                } else if (c >= 'A' && c <= 'Z') {
                    return 'A' + (c - 'A' + n) % 26;
                } else {
                    return c;
                }
            }).mapToObj(c -> String.valueOf((char) c))
                    .reduce((a, b) -> a + b).orElse("");
        }

    }
}
