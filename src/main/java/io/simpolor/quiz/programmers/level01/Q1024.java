package io.simpolor.quiz.programmers.level01;

import java.util.*;

public class Q1024 {

    /***
     * 정수 내림차순으로 배치하기
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 함수 solution은 정수 n을 매개변수로 입력받습니다.
     * n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
     * 예를들어 n이 118372면 873211을 리턴하면 됩니다.
     *
     * ------------------------------
     * 제한 조건
     * ------------------------------
     * n은 1이상 8000000000 이하인 자연수입니다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * n	return
     * 118372	873211
     *
     */
    public static void main(String[] args){

        long n = 873211;

        Solution solution = new Solution();
        long result = solution.solution(n);

        System.out.println(result);
    }

    public static class Solution {
        public long solution(long n) {

            char[] chars = String.valueOf(n).toCharArray();

            Arrays.sort(chars);

            System.out.println(chars);
            String s = "";
            for(int i=chars.length-1; 0<=i; i--){
                s += chars[i];
            }

            return Long.valueOf(s);
        }
    }

    public static class Solution1 {
        public long solution(long n) {
            long answer = 0;
            String str = Long.toString(n);
            char[] c = new char[str.length()];
            for (int i=0; i<str.length(); i++) {
                c[i] = str.charAt(i);
            }
            Arrays.sort(c);
            str = "";
            for (int i=0; i<c.length; i++) {
                str = str + c[c.length-1-i];
            }
            answer = Long.parseLong(str);
            return answer;
        }
    }

    public static class Solution2 {
        public long solution(long n) {
            char[] array = String.valueOf(n).toCharArray();
            Arrays.sort(array);

            StringBuilder sb = new StringBuilder();
            for(char a : array) {
                sb.append(a);
            }

            return Long.parseLong(sb.reverse().toString());
        }
    }

    public static class Solution3 {
        public long solution(long n) {
            long answer;
            String s = n + "";
            String[] str = s.split("");
            StringBuffer sb = new StringBuffer();
            Arrays.sort(str, Collections.reverseOrder());
            for (int i = 0 ; i < str.length ; i++){
                sb.append(str[i]);
            }
            answer = Long.parseLong(sb.toString());
            return answer;
        }
    }

    public static class Solution4 {
        public long solution(long n) {
            long answer = 0;

            String numStr = Long.toString(n);
            String[] nums = numStr.split("");

            Arrays.sort(nums, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return Integer.parseInt(o2) - Integer.parseInt(o1);
                }
            });

            StringBuilder sb = new StringBuilder();
            for(String num : nums) {
                sb.append(num);
            }

            answer = Long.parseLong(sb.toString());

            return answer;
        }
    }

    public static class Solution5 {
        public long solution(long n) {
            long answer = 0;
            ArrayList<Integer> arr = new ArrayList<Integer>();
            while(n>0){
                arr.add((int)(n%10));
                n = n/10;
            }
            Collections.sort(arr);
            for(int i = 0 ; i<arr.size() ; i++){
                answer += (long)(Math.pow(10,i) * arr.get(i));
            }
            return answer;
        }
    }


    public static class Solution6 {

        String res = "";
        public int solution(int n){

            res = "";
            Integer.toString(n).chars().sorted().forEach(c -> res = Character.valueOf((char)c) + res);
            return Integer.parseInt(res);
        }

    }




}
