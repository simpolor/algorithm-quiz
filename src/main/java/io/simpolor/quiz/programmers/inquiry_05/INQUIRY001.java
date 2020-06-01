package io.simpolor.quiz.programmers.inquiry_05;

import java.util.*;

/***
 * 모의고사
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
 * 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 *
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 *
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
 * 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * ------------------------------
 * 제한 조건
 * ------------------------------
 * 시험은 최대 10,000 문제로 구성되어있습니다.
 * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * answers	return
 * [1,2,3,4,5]	[1]
 * [1,3,2,4,2]	[1,2,3]
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 입출력 예 #1
 *
 * 수포자 1은 모든 문제를 맞혔습니다.
 * 수포자 2는 모든 문제를 틀렸습니다.
 * 수포자 3은 모든 문제를 틀렸습니다.
 * 따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
 *
 * 입출력 예 #2
 *
 * 모든 사람이 2문제씩을 맞췄습니다.
 */
public class INQUIRY001 {

    public static void main(String[] args) {

        int[] answers = new int[]{3, 0, 6, 1, 5};

        Solution solution = new Solution();
        int[] result = solution.solution(answers);

        System.out.println(Arrays.toString(result));
    }

    public static class Solution {
        public int[] solution(int[] answer) {

            int[] a = {1, 2, 3, 4, 5};
            int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
            int[] score = new int[3];

            for(int i=0; i<answer.length; i++) {
                if(answer[i] == a[i%a.length]) {score[0]++;}
                if(answer[i] == b[i%b.length]) {score[1]++;}
                if(answer[i] == c[i%c.length]) {score[2]++;}
            }

            int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
            ArrayList<Integer> list = new ArrayList<>();
            if(maxScore == score[0]) {list.add(1);}
            if(maxScore == score[1]) {list.add(2);}
            if(maxScore == score[2]) {list.add(3);}

            return list.stream().mapToInt(i->i.intValue()).toArray();
        }
    }

    public static class Solution1 {
        public int[] solution(int[] answers) {
            int[] arr = new int[3];
            int[] a = {5,1,2,3,4};
            int[] b = {5,2,1,2,3,2,4,2};
            int[] c = {5,3,3,1,1,2,2,4,4,5};

            for(int i = 0; i < answers.length; i++){
                if(answers[i] == a[(i+1)%5]) arr[0]++;
                if(answers[i] == b[(i+1)%8]) arr[1]++;
                if(answers[i] == c[(i+1)%10]) arr[2]++;
            }

            int max = arr[0];

            if(max < arr[1]) max = arr[1];
            if(max < arr[2]) max = arr[2];

            if(max == arr[0] && max == arr[1] && max == arr[2]) return new int[]{1,2,3};
            else if(max == arr[0] && max == arr[1]) return new int[]{1,2};
            else if(max == arr[0] && max == arr[2]) return new int[]{1,3};
            else if(max == arr[1] && max == arr[2]) return new int[]{2,3};
            else if(max == arr[0]) return new int[]{1};
            else if(max == arr[1]) return new int[]{2};

            return new int[]{3};
        }
    }

    public static class Solution2 {
        public int[] solution(int[] answers) {
            int[] m = new int[3];
            int[] supo1 = { 1, 2, 3, 4, 5 };
            int[] supo2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
            int[] supo3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
            for (int i = 0; i < answers.length; ++i) {
                if (answers[i] == supo1[i % 5]) {
                    ++m[0];
                }
                if (answers[i] == supo2[i % 8]) {
                    ++m[1];
                }
                if (answers[i] == supo3[i % 10]) {
                    ++m[2];
                }
            }
            LinkedList<Integer> list = new LinkedList<Integer>();
            int max = 0;
            for (int i = 0; i < 3; ++i) {
                if (m[i] > max) {
                    list = new LinkedList<Integer>();
                    list.add(i + 1);
                    max = m[i];
                } else if (m[i] == max) {
                    list.add(i + 1);
                }
            }
            int[] res = new int[list.size()];
            for (int i = 0; i < res.length; ++i) {
                res[i] = list.get(i);
            }

            return res;
        }
    }

    public static class Solution3 {
        public int[] solution(int[] answers) {
            int[] answer = {};

            int[][] student = {
                    {1,2,3,4,5},
                    {2,1,2,3,2,4,2,5},
                    {3,3,1,1,2,2,4,4,5,5}
            };

            int check[] = new int[3];

            //정답 수 체크
            for(int i=0; i<answers.length; i++) {
                for(int j =0; j<3; j++) {
                    if(answers[i]==student[j][i%student[j].length])
                        check[j]++;
                }
            }

            //최대수 구하기
            int temp = 0;
            for(int i=0; i<check.length; i++)
                if(temp<check[i])   temp = check[i];

            int size = 0;
            for(int i=0;i<check.length; i++) if(check[i]==temp) size++;

            answer = new int[size];
            int num = 0;
            for(int i=0; i<check.length; i++) {
                if(check[i]==temp) {
                    answer[num] = i+1;
                    num++;
                }
            }
            return answer;
        }
    }


}
