package io.simpolor.quiz.programmers.condingTestPractice.inquiry05;

import java.util.*;

/***
 * 소수 찾기
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 *
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
 * 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 * numbers는 길이 1 이상 7 이하인 문자열입니다.
 * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
 * 013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * numbers	return
 * 17	3
 * 011	2
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 예제 #1
 * [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
 *
 * 예제 #2
 * [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
 *
 * 11과 011은 같은 숫자로 취급합니다.
 *
 */
public class INQUIRY002 {

    public static void main(String[] args) {

        String numbers = "17";

        Solution solution = new Solution();
        int result = solution.solution(numbers);

        System.out.println(result);
    }

    public static class Solution {
        public int solution(String numbers) {

            HashSet<Integer> set = new HashSet<>();
            permutation("", numbers, set);

            int count = 0;
            while(set.iterator().hasNext()){

                int a = set.iterator().next();

                set.remove(a);

                if(a==2) count++;
                if(a%2!=0 && isPrime(a)){
                    count++;
                }
            }
            return count;
        }

        public boolean isPrime(int n){

            if(n==0 || n==1) return false;

            for(int i=3; i<=(int)Math.sqrt(n); i+=2){
                if(n%i==0) return false;
            }

            return true;
        }

        public void permutation(String prefix, String str, HashSet<Integer> set) {
            int n = str.length();
            if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);

        }

    }

    public static class Solution1 {
        TreeSet<Integer> ts = new TreeSet<>();

        public int solution(String numbers) {
            int answer = 0,check, i;
            func("",numbers);

            for(int num:ts){

                check = 0;
                for(i=2;i<num;i++){
                    if(num%i==0)
                        break;
                }
                if(i==num)
                    answer++;
            }
            return answer;
        }

        public void func(String s, String number) {
            if (number.length() == 0) {
                if(!s.equals(""))
                    ts.add(Integer.parseInt(s));
            } else {
                for (int i = 0; i < number.length(); i++)
                    func(s + number.charAt(i), number.substring(0, i) + number.substring(i + 1, number.length()));
                for (int i = 0; i < number.length(); i++)
                    func(s , number.substring(0, i) + number.substring(i + 1, number.length()));
            }
        }
    }

    public static class Solution2 {

        public int solution(String numbers) {
            int answer = 0;
            boolean[] data = new boolean[10000001];
            for(int i=0; i<data.length; i++) {data[i] = true;}
            for(int i=2; i<data.length; i++) {
                if(data[i]) {
                    for(int j=i*2; j<data.length; j+=i) {
                        data[j] = false;
                    }
                }
            }
            data[1] = false;

            int[] nArr = toNumArray(numbers);
            for(int i=2; i<data.length; i++) {
                if(data[i]) {
                    int[] iArr = toNumArray(Integer.toString(i));
                    if(isPossible(nArr, iArr)) {answer++;}
                }
            }

            return answer;
        }

        int[] toNumArray(String s) {
            int[] result = new int[10];
            for(int i=0; i<s.length(); i++) {
                result[s.charAt(i)-'0']++;
            }
            return result;
        }

        boolean isPossible(int[] nArr, int[] iArr) {
            for(int i=0; i<10; i++) {
                if(nArr[i] < iArr[i]) {return false;}
            }
            return true;
        }
    }

    public static class Solution3 {
        static Set<Integer> set = new HashSet<>();
        public int solution(String numbers) {
            int answer = 0;
            char[] nums = new char[numbers.length()];
            for(int i = 0; i < nums.length; i++) {
                nums[i] = numbers.charAt(i);
            }
            int n = numbers.length();
            for(int i = 1; i < (1 << n); i++) {
                char[] temp = new char[7];
                boolean[] chk = new boolean[7];
                int k = 0;
                for(int j = 0; j < n; j++) {
                    if((i & (1 << j)) > 0) {
                        temp[k++] = nums[j];
                    }
                }
                answer += solve(temp, chk, k, 0, "");
            }

            return answer;
        }
        static int solve(char[] temp, boolean[] chk, int k, int start, String number) {
            if(start == k) {
                int num = Integer.parseInt(number);
                if(!set.contains(num)) {
                    if(isPrime(num)) {
                        set.add(num);
                        return 1;
                    }
                }
                return 0;
            }
            int result = 0;
            for(int i = 0; i < k; i++) {
                if(!chk[i]) {
                    chk[i] = true;
                    result += solve(temp, chk, k, start + 1, number + temp[i]);
                    chk[i] = false;
                }
            }
            return result;
        }
        static boolean isPrime(int n) {
            if(n <= 1) {
                return false;
            }
            for(int i = 2; i * i <= n; i++) {
                if(n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
