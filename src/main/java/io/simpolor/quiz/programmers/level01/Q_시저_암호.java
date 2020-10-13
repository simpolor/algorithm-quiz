package io.simpolor.quiz.programmers.level01;

public class Q_시저_암호 {

    /***
     * 시저 암호 ( 연습문제 )
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
     *
     * 예를 들어
     * AB는 1만큼 밀면 BC가 되고, 3만큼 밀면 DE가 됩니다.
     * z는 1만큼 밀면 a가 됩니다.
     * 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
     *
     * ------------------------------
     * 제한 조건
     * ------------------------------
     * 공백은 아무리 밀어도 공백입니다.
     * s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
     * s의 길이는 8000이하입니다.
     * n은 1 이상, 25이하인 자연수입니다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * s	n	result
     * AB	1	BC
     * z	1	a
     * a B z	4	e F d
     *
     */
    public static void main(String[] args){

        // String s = "AB";
        // String s = "z";
        // int n = 1;

        String s = "a B z";
        int n = 4;

        Solution solution = new Solution();
        String result = solution.solution(s, n);

        System.out.println(result);
    }


    public static class Solution {
        public String solution(String s, int n) {

            String answer = "";

            char[] chars = s.toCharArray();

            for(char c : chars){
                if(c == 90){
                    answer += (char)(65+(n-1));
                }else if(c == 122){
                    answer += (char)(97+(n-1));
                }else if(c == 32){
                    answer += (char)32;
                }else {
                    answer += (char) (c + n);
                }
            }

            return answer;
        }
    }

    public static class Solution1 {
        private char cipher(char src, int n) {
            if(Character.isLowerCase(src)) {
                return (char)((src - 'a' + n) % 26 + 'a');
            } else if(Character.isUpperCase(src)) {
                return (char)((src - 'A' + n) % 26 + 'A');
            } else
                return src;
        }

        public String solution(String s, int n) {
            int length = s.length();

            char[] chars = s.toCharArray();
            char[] result = new char[length];

            for(int index = 0; index < length ;index++)
                result[index] = cipher(chars[index], n);

            return new String(result);
        }
    }

    public static class Solution2 {
        public String solution(String s, int n) {
            String answer = "";
            int a;
            for(int i = 0; i < s.length(); i++){
                a = s.charAt(i);
                if (a!=32){
                    a = (Character.isUpperCase(a))? (a-65+n)%26+65 : (a-97+n)%26+97;
                }
                answer += (char)a;
            }
            return answer;
        }
    }

    public static class Solution3 {
        public String solution(String s, int n) {
            StringBuilder sb = new StringBuilder();
            for(int i=0 ; i<s.length() ; i++) {
                char ch = s.charAt(i);

                if(ch == ' ') sb.append(" ");
                else if(ch >= 65 && ch <= 90) {     //대문자
                    int temp = (int)(ch + n);
                    if(temp > 90) temp -= 26;
                    sb.append((char)temp);
                } else {                            //소문자
                    int temp = (int)(ch + n);
                    if(temp > 122) temp -= 26;
                    sb.append((char)temp);
                }
            }
            return sb.toString();
        }
    }

    public static class Solution4 {
        public String solution(String s, int n) {
            StringBuilder sb = new StringBuilder();
            for (char ch : s.toCharArray()) {
                if (ch >= 'a' && ch <= 'z') {
                    ch += n;
                    if (ch > 'z') {
                        ch -= 26;
                    }
                } else if (ch >= 'A' && ch <= 'Z') {
                    ch += n;
                    if (ch > 'Z') {
                        ch -= 26;
                    }
                }
                sb.append((char) ch);
            }
            return sb.toString();
        }
    }

    public static class Solution5 {
        public String solution(String s, int n) {
            String answer = "";
            for(int i=0;i<s.length();i++){
                int a = s.charAt(i);
                if(a!=' '){
                    a = (Character.isUpperCase(a)) ? (a-65+n)%26+65 : (a-97+n)%26+97;
                }
                answer+= Character.toString((char)a);
            }
            return answer;
        }
    }

    public static class Solution6 {
        public String solution(String s, int n) {
            String answer = "";

            String alpabetstring = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String salpabetstring = "abcdefghijklmnopqrstuvwxyz";

            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == ' ')
                    answer += " ";

                else {
                    if (Character.isUpperCase(s.charAt(i))) {
                        int tmp = alpabetstring.indexOf(s.charAt(i))+n;
                        if (tmp > alpabetstring.length()-1)
                            tmp = tmp - alpabetstring.length();
                        answer += alpabetstring.substring(tmp, tmp+1);
                    }
                    else {
                        int tmp = salpabetstring.indexOf(s.charAt(i))+n;
                        if (tmp > salpabetstring.length()-1)
                            tmp = tmp - salpabetstring.length();
                        answer += salpabetstring.substring(tmp, tmp+1);
                    }

                }
            }

            return answer;
        }
    }
}
