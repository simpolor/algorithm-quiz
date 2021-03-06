package io.simpolor.quiz.programmers.condingTestPractice.hash01;

import java.util.*;

/***
 * 전화번호 목록
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 *
 * 구조대 : 119
 * 박준영 : 97 674 223
 * 지영석 : 11 9552 4421
 *
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
 * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 *
 * 접두어 : 앞에 붙이는 언어 ( startWith )
 *
 *------------------------------
 * 제한 사항
 * ------------------------------
 * phone_book의 길이는 1 이상 1,000,000 이하입니다.
 * 각 전화번호의 길이는 1 이상 20 이하입니다.
 *
 * ------------------------------
 * 입출력 예제
 * ------------------------------
 * phone_book	return
 * [119, 97674223, 1195524421],	false
 * [123, 456, 789], 	true
 * [12, 123, 1235, 567, 88],	false
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 입출력 예 #1
 * 앞에서 설명한 예와 같습니다.
 *
 * 입출력 예 #2
 * 한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.
 *
 * 입출력 예 #3
 * 첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.
 *
 * 알림
 *
 * 2019년 5월 13일, 테스트 케이스가 변경되었습니다. 이로 인해 이전에 통과하던 코드가 더 이상 통과하지 않을 수 있습니다.
 *
 */
public class HASH002 {

    public static void main(String[] args) {

        // String[] phoneBook = new String[]{"119", "97674223", "1195524421"};
        String[] phoneBook = new String[]{"123", "456", "789"};
        // String[] phoneBook = new String[]{"12", "123", "1235", "567", "88"};

        Solution solution = new Solution();
        boolean result = solution.solution(phoneBook);

        System.out.println(result);
    }

    public static class Solution {

        public boolean solution(String[] phoneBook) {

            for(int i=0; i<phoneBook.length; i++){
                for(int j=0; j<phoneBook.length; j++){

                    // 같은 번호는 통과
                    if(i == j){
                        continue;
                    }

                    //
                    if(phoneBook[i].startsWith(phoneBook[j])){
                        return false;
                    }
                }
            }

            return true;
        }
    }

    public static class Solution1 {

        public boolean solution(String[] phoneBook) {

            for(int i=0; i<phoneBook.length-1; i++) {
                for(int j=i+1; j<phoneBook.length; j++) {
                    if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                    if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
                }
            }
            return true;
        }
    }

    // contains 의 경우 해당 문자열이 포함인지를 비교하므로, 실제 문제 내용과 조금 다르다.
    public static class Solution2 {

        public boolean solution(String[] phoneBook) {

            Arrays.sort(phoneBook);
            boolean result = true;
            for (int i=0; i<phoneBook.length-1; i++) {
                if (phoneBook[i+1].contains(phoneBook[i])) {
                    result = false;
                    break;
                }
            }
            return result;
        }
    }

    public static class Solution3 {

        public boolean solution(String[] phoneBook) {
            Arrays.sort(phoneBook);

            boolean answer = true;
            for(int i=0; i<phoneBook.length; i++){
                for(int j=i+1; j<phoneBook.length; j++){
                    if(phoneBook[j].contains(phoneBook[i])){
                        return false;
                    }
                }
            }
            return answer;
        }
    }

}
