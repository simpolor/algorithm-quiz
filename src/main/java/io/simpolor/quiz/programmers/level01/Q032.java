package io.simpolor.quiz.programmers.level01;

public class Q032 {

    /***
     * 하샤드 수
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.
     * 예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.
     * 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
     *
     * ------------------------------
     * 제한 조건
     * ------------------------------
     * x는 1 이상, 10000 이하인 정수입니다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * arr	return
     * 10	true
     * 12	true
     * 11	false
     * 13	false
     *
     * ------------------------------
     * 입출력 예 설명
     * ------------------------------
     * 입출력 예 #1
     * 10의 모든 자릿수의 합은 1입니다. 10은 1로 나누어 떨어지므로 10은 하샤드 수입니다.
     *
     * 입출력 예 #2
     * 12의 모든 자릿수의 합은 3입니다. 12는 3으로 나누어 떨어지므로 12는 하샤드 수입니다.
     *
     * 입출력 예 #3
     * 11의 모든 자릿수의 합은 2입니다. 11은 2로 나누어 떨어지지 않으므로 11는 하샤드 수가 아닙니다.
     *
     * 입출력 예 #4
     * 13의 모든 자릿수의 합은 4입니다. 13은 4로 나누어 떨어지지 않으므로 13은 하샤드 수가 아닙니다.
     *
     */
    public static void main(String[] args){

        int x = 10;
        // int x = 12;
        // int x = 11;
        // int x = 13;

        Solution solution = new Solution();
        boolean result = solution.solution(x);

        System.out.println(result);
    }

    public static class Solution {
        public boolean solution(int x) {

            char[] chars = String.valueOf(x).toCharArray();

            int harshad = 0;
            for(char c : chars){
                harshad += Character.getNumericValue(c);
            }

            if(x % harshad == 0){
                return true;
            }
            return false;
        }
    }

    // 별별 좋아
    public static class Solution1{
        public boolean solution(int x) {

            int sum = 0;
            int temp = x;

            while(x != 0){
                sum += x % 10;
                x = x /10;
            }

            return (temp % sum == 0) ? true : false;
        }
    }

    public static class Solution2 {
        public boolean solution(int x) {
            int digitSum = 0;
            String numStr = String.valueOf(x);
            for(int i=0;i<numStr.length();i++) {
                digitSum += Character.getNumericValue(numStr.charAt(i));
                System.out.println(digitSum);
            }
            return (x%digitSum == 0)? true : false;
        }
    }

}
